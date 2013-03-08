package controller;

import javax.servlet.ServletException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect the user to login with the NUID Authentication Service
        response.sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=https://localhost:8181/financeTool/terms");
    }
}
