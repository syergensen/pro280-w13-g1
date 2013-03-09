package controller;

import manager.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ResultCalculator", urlPatterns = {"/result/calculate"},
        initParams =
                {
                        @WebInitParam(name = "success", value = "/results.jsp"),
                        @WebInitParam(name = "failure", value = "/aspirations.jsp")})
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        String degree = (String)session.getAttribute("degree");
        Double extraquarterfull = Double.parseDouble((String)session.getAttribute("extra-quarter-full"));
        Double extraquarterpart = Double.parseDouble((String)session.getAttribute("extra-quarter-part"));
        Double loanpercent = Double.parseDouble((String)session.getAttribute("loan-percent"));
        Double debt1 = Double.parseDouble((String)session.getAttribute("debt1"));
        Double debt2 = Double.parseDouble((String)session.getAttribute("debt2"));
        Double debt3 = Double.parseDouble((String)session.getAttribute("debt3"));

        //calculates the result
        Double income = degreeManager.findDegree(degree).getSalary() / 12;
        Double healthinsurance = 0.00;
        Double miscinsurance = 0.00;

        Double carcost = carManager.getCar(1).getPrice();
        Double carintrest = carcost * .4;
        Double carpayment = carcost + carintrest;
        carpayment = carpayment / 48;

        Double mortgage = housingManager.getHousing(1).getRent();
        Double utilities = housingManager.getHousing(1).getUtilities();

        Double inschoolhousing = housingManager.getHousing(1).getRent();
        inschoolhousing += housingManager.getHousing(1).getUtilities();

        //quarter is 10 weeks
        Double totalloans = degreeManager.findDegree(degree).getDuration() * 7200.0 / 12;
        totalloans += degreeManager.findDegree(degree).getDuration() * inschoolhousing;

        Double inschoolsavings = 0.00;
        Double discretionary = 0.00;

        session.setAttribute("income", income);
        session.setAttribute("healthinsurance", healthinsurance);
        session.setAttribute("miscinsurance", miscinsurance);
        session.setAttribute("carpayment", carpayment);
        session.setAttribute("mortgage", mortgage);
        session.setAttribute("utilities", utilities);
        session.setAttribute("totalloans", totalloans);
        session.setAttribute("inschoolsavings", inschoolsavings);
        session.setAttribute("discretionary", discretionary);

        request.getRequestDispatcher(getServletConfig().getInitParameter("success")).forward(request, response);
//        Salary..................${salary}<br>
//            Income Tax..............${income}<br>
//            Health Insurance........${healthinsurance}<br>
//            Misc. Insurance.........${miscinsurance}<br>
//            Car Payment.............${carpayment}<br>
//            Mortgage/Rent...........${mortgage}<br>
//            Utilities...............${utilities}<br>
//            Total Loans.............${totalloans}<br>
//            In-School Savings.......${inschoolsavings}<br>
//        <br>
//        <br>
//            Discretionary Income: ${discretionary}

    }

}
