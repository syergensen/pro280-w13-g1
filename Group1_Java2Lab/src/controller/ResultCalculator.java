package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jrowley
 * Date: 3/1/13
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ResultCalculator", urlPatterns = {"/result/calculate"},
        initParams =
                {
                        @WebInitParam(name = "success", value = "/results.jsp"),
                        @WebInitParam(name = "failure", value = "/aspirations.jsp")})
public class ResultCalculator extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String quarter = request.getParameter("quarter");
        Integer year = Integer.parseInt(request.getParameter("year"));
        String degree = request.getParameter("degree");
        Float extraquarterfull = Float.valueOf(request.getParameter("extra-quarter-full"));
        Float extraquarterpart = Float.valueOf(request.getParameter("extra-quarter-part"));
        Float loanpercent = Float.valueOf(request.getParameter("loan-percent"));
        Float debt1 = Float.valueOf(request.getParameter("debt1"));
        Float debt2 = Float.valueOf(request.getParameter("debt2"));
        Float debt3 = Float.valueOf(request.getParameter("debt3"));

        //calculates the result

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
