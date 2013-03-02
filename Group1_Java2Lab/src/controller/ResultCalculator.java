package controller;

import javax.servlet.ServletException;
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
@WebServlet(name = "ResultCalculator", urlPatterns = "/result/calculate")
public class ResultCalculator extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String quarter = request.getParameter("quarter");
        Integer year = Integer.parseInt(request.getParameter("year"));
        String degree = request.getParameter("degree");
        Integer extraquarterfull = Integer.parseInt(request.getParameter("extra-quarter-full"));
        Integer extraquarterpart = Integer.parseInt(request.getParameter("extra-quarter-part"));
        Integer loanpercent = Integer.parseInt(request.getParameter("loan-percent"));
        Integer debt1 = Integer.parseInt(request.getParameter("debt1"));
        Integer debt2 = Integer.parseInt(request.getParameter("debt2"));
        Integer debt3 = Integer.parseInt(request.getParameter("debt3"));

    }

}
