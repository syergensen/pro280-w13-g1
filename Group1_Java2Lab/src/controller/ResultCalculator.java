package controller;

import manager.*;
import model.*;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResultCalculator", urlPatterns = {"/results"},
        initParams =
                {
                        @WebInitParam(name = "success", value = "WEB-INF/results.jsp"),
                        @WebInitParam(name = "failure", value = "WEB-INF/aspirations.jsp")})
public class ResultCalculator extends HttpServlet
{
    @EJB
    CarManager carManager;
    @EJB
    DebtTypeManager debtTypeManager;
    @EJB
    DegreeManager degreeManager;
    @EJB
    HousingManager housingManager;
    @EJB
    MiscManager miscManager;
    @EJB
    RegionManager regionManager;

    Calculator calc = new Calculator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        if(request.getParameter("region") != null)
        {
            session.setAttribute("region", request.getParameter("region"));
        }


        //School
        String startMonth = (String)session.getAttribute("quarter");
        Integer startYear = Integer.parseInt((String)session.getAttribute("year"));
        Region region = regionManager.findRegion((String)session.getAttribute("region"));
        List<Degree> degrees = degreeManager.getDegrees();
        Degree degree = new Degree();

        String regionName = request.getParameter("region");

        if(regionName != null)
        {
            session.setAttribute("regionName", regionName);
        }

        for(int i=0;i<degrees.size();i++)
        {
            if(degrees.get(i).getDegree().equals(session.getAttribute("degree")) &&
               degrees.get(i).getRegion().equals(session.getAttribute("regionName")))
            {
                degree = degrees.get(i);
            }
        }

        Integer expectedFull = Integer.parseInt((String)session.getAttribute("extra-quarter-full"));
        Integer expectedPart = Integer.parseInt((String)session.getAttribute("extra-quarter-part"));

        Double extraQuarter = 0.0;
        if(session.getAttribute("extraQuarter") == null)
        {
            if(expectedFull != null)
            {
                extraQuarter += expectedFull;
            }
            if(expectedPart != null)
            {
                extraQuarter += (expectedPart/2);
            }
            session.setAttribute("extraQuarter", extraQuarter);
        }
        else
        {
            extraQuarter = (Double)session.getAttribute("extraQuarter");
        }

        Integer loanPercent = Integer.parseInt((String)session.getAttribute("loan-percent"));
        Double scholarships = Double.parseDouble((String)session.getAttribute("scholarships"));
        Integer interestRate = Integer.parseInt((String)session.getAttribute("interestrate"));
        Double debt1 = Double.parseDouble((String)session.getAttribute("debt1"));
        Double debt2 = Double.parseDouble((String)session.getAttribute("debt2"));
        Double debt3 = Double.parseDouble((String)session.getAttribute("debt3"));

        //Housing & Lifestyle
        Double rent = Double.parseDouble((String) session.getAttribute("rent"));
        Double utilities = Double.parseDouble((String)session.getAttribute("utilities"));
        Double lunch = Double.parseDouble((String)session.getAttribute("go_out_to_lunch"));
        Double dinner = Double.parseDouble((String)session.getAttribute("go_out_to_dinner"));
        Double entertainment = Double.parseDouble((String)session.getAttribute("spend_on_entertainment"));

        //Post-Graduation
        List<Car> allCars = carManager.getCars();
        String carStat = request.getParameter("car_status");
        String carQual = request.getParameter("car_quality");
        String carMPG = request.getParameter("fuel_economy");

        if(carStat != null && carQual != null && carMPG != null)
        {
            session.setAttribute("car_status", carStat);
            session.setAttribute("car_quality", carQual);
            session.setAttribute("fuel_economy", carMPG);
        }




        Car car = new Car();
        for(int i=0;i<allCars.size();i++)
        {
            if(allCars.get(i).getStatus().equals((String)session.getAttribute("car_status")))
            {
                if(allCars.get(i).getQuality().equals((String)session.getAttribute("car_quality")))
                {
                    if(allCars.get(i).getMpg().equals((String)session.getAttribute("fuel_economy")))
                    {
                        car.setId(allCars.get(i).getId());
                        car.setStatus(allCars.get(i).getStatus());
                        car.setQuality(allCars.get(i).getQuality());
                        car.setMpg(allCars.get(i).getMpg());
                        car.setPrice(allCars.get(i).getPrice());
                    }
                }
            }
        }
        Double housingCost;
        String house = request.getParameter("housing");
        if(house != null)
        {
            session.setAttribute("housing", house);
        }
        if(session.getAttribute("housing").equals("Own"))
        {
            housingCost = region.getHousing();
        }
        else if(session.getAttribute("housing").equals("Rent"))
        {
            housingCost = region.getRent();
        }
        else
        {
            housingCost = 0.0;
        }

        Double carInterest;
        if(request.getParameter("carinterest") == null)
        {
            carInterest = (Double)session.getAttribute("carInterest");

        }
        else
        {
            carInterest = Double.parseDouble(request.getParameter("carinterest"));
        }

        if(carInterest != null)
        {
            session.setAttribute("carInterest", carInterest);
        }
        if(session.getAttribute("carInterest") != null)
        {
            carInterest = (Double)session.getAttribute("carInterest");
        }

        Double salary;
        Double studentloan;
        Double incometax;
        Double miscexpenses;
        Double carexpenses;
        Double mortgage;
        Double miscloans;
        Double savings;
        Double discretionary;

        //Salary
        salary = degree.getSalary() / 12;

        //Student loan
        if(loanPercent == 0)
        {
            studentloan = 0.0;
        }
        else
        {
            Double totalprice = (degree.getDuration() + extraQuarter) * 7200.0;
            Double totalrent = rent / 4.34812 * 100;
            Double totalutilities = utilities / 4.34812 * 100;
            totalprice += (totalrent + totalutilities - scholarships);
            Double totalloan = totalprice * (loanPercent / 100);
            Double annualrate = interestRate / 1200.0;
//            Double payment = annualrate + (annualrate / (Math.pow(annualrate + 1, 120) - 1)) * totalloan;
            Double payment = Math.pow(annualrate + 1, 120);
            payment -= 1;
            payment = annualrate / payment;
            payment += annualrate;
            payment = payment * totalloan;
            studentloan = payment;
        }

        //Income tax
        Double firstBracket = 9000 * 0.1;
        Double secondBracket = (36000 - 9000) * 0.15;
        Double thirdBracket = (degree.getSalary() - 36000) * .25;
        incometax = firstBracket + secondBracket + thirdBracket;
        incometax = incometax / 12;

        // Misc Expenses
        Double lunchMonth = lunch * 4.34812;
        Double dinnerMonth = dinner * 4.34812;
        miscexpenses = lunchMonth + dinnerMonth + entertainment;

        //Car Expenses High end, Average, Below average
        String mpgString = car.getMpg();
        Double mpg = 0.0;
        if(mpgString.equals("High end"))
        {
            mpg = 37.0;
        }
        else if(mpgString.equals("Average"))
        {
            mpg = 27.5;
        }
        else
        {
            mpg = 14.0;
        }
        Double gasMonth = 1600 / mpg * 3.6;
        Double annualCarInterest = carInterest / 1200;
        Double carPayment = Math.pow(annualCarInterest + 1, 120);
        carPayment -= 1;
        carPayment = annualCarInterest / carPayment;
        carPayment += annualCarInterest;
        carPayment = carPayment * car.getPrice();
        carexpenses = gasMonth + carPayment;

        //Misc. Loans
        //to be determined
        Double annualDebt1 = 1/1200.0;
        Double annualDebt2 = 6/1200.0;
        Double annualDebt3 = 5/1200.0;

        Double debt1Loan = Math.pow(annualDebt1 + 1, 12);
        debt1Loan -= 1;
        debt1Loan = annualDebt1 / debt1Loan;
        debt1Loan += annualDebt1;
        debt1Loan = debt1Loan * debt1;

        Double debt2Loan = Math.pow(annualDebt2 + 1, 12);
        debt2Loan -= 1;
        debt2Loan = annualDebt2 / debt2Loan;
        debt2Loan += annualDebt2;
        debt2Loan = debt2Loan * debt2;

        Double debt3Loan = Math.pow(annualDebt3 + 1, 12);
        debt3Loan -= 1;
        debt3Loan = annualDebt3 / debt3Loan;
        debt3Loan += annualDebt3;
        debt3Loan = debt3Loan * debt3;

        miscloans = debt1Loan + debt2Loan + debt3Loan;

        discretionary = salary - (studentloan + incometax + miscexpenses + carexpenses + housingCost + miscloans);


        Double truncSal = calc.truncate(salary);
        Integer newSal = truncSal.intValue();
        Double truncStudLoan = calc.truncate(studentloan);
        Integer newStudLoan = truncStudLoan.intValue();
        Double truncIncomeTax = calc.truncate(incometax);
        Integer newIncomeTax = truncIncomeTax.intValue();
        Double truncMiscEx = calc.truncate(miscexpenses);
        Integer newMiscEx = truncMiscEx.intValue();
        Double truncCarEx = calc.truncate(carexpenses);
        Integer newCarEx = truncCarEx.intValue();
        Double truncHouseCost = calc.truncate(housingCost);
        Integer newHouseCost = truncHouseCost.intValue();
        Double truncMiscLoans = calc.truncate(miscloans);
        Integer newMiscLoans = truncMiscLoans.intValue();
        Double truncDiscret = calc.truncate(discretionary);
        Integer newDiscret = truncDiscret.intValue();


        session.setAttribute("salary", newSal);
        session.setAttribute("studentloan", newStudLoan);
        session.setAttribute("incometax", newIncomeTax);
        session.setAttribute("miscexpenses", newMiscEx);
        session.setAttribute("carexpenses", newCarEx);
        session.setAttribute("mortgage", newHouseCost);
        session.setAttribute("miscloans", newMiscLoans);
        session.setAttribute("discretionary", newDiscret);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/results.jsp");
        dispatcher.forward(request, response);

    }

}
