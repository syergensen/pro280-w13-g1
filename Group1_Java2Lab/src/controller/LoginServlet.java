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
 * User: sgomez
 * Date: 2/26/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // validate users credentials with NUID Authentication service
//        response.sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=https://localhost:8181/financeTool" + getServletContext().getInitParameter("StartPage"));
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // direct the user to login with the login page
//        request.getRequestDispatcher((getServletContext().getInitParameter("LoginPage"))).forward(request, response);
        response.sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=https://localhost:8181/financeTool/start.jsp");
    }
}
