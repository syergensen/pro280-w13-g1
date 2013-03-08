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

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/1/13
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/terms", initParams =
@WebInitParam(name="start", value="start.jsp"))
public class TermsServlet extends HttpServlet {
    @EJB
    private TermsManager termsManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TermsOfService serviceTerms = termsManager.getTerms();
        request.setAttribute("termsOfService", serviceTerms);
        request.getRequestDispatcher(getServletConfig().getInitParameter("start")).forward(request, response);
    }
}
