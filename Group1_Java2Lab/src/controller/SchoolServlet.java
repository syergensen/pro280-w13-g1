package controller;

import manager.DebtTypeManager;
import manager.DegreeManager;
import manager.QuarterManager;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: acottrill
 * Date: 2/27/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "school", urlPatterns = {"/school"})
public class SchoolServlet extends javax.servlet.http.HttpServlet {
    @EJB
    private QuarterManager qm;

    @EJB
    private DegreeManager dm;

    @EJB
    private DebtTypeManager dtm;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("all_quarters", qm.getQuarters());
        request.setAttribute("all_degrees", dm.getDegrees());
        request.setAttribute("all_debtTypes", dtm.getDebtTypes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/school.jsp");
        dispatcher.forward(request, response);
    }
}
