package controller;

import manager.TermsManager;
import model.TermsOfService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/terms", initParams =
@WebInitParam(name="start", value="/WEB-INF/start.jsp"))
public class TermsServlet extends HttpServlet {
    @EJB
    private TermsManager termsManager;

    // grabs the terms of service from the ServiceTerms table in the database
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TermsOfService serviceTerms = termsManager.getTerms();
        // sets the terms of service in an attribute on the request
        request.setAttribute("termsOfService", serviceTerms);
        request.getRequestDispatcher(getServletConfig().getInitParameter("start")).forward(request, response);
    }
}
