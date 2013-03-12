package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/start", initParams = {
@WebInitParam(name="SchoolPage", value="school"),
        @WebInitParam(name="Terms", value="terms")
})
public class StartPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // make sure the user reads the Terms of Service
        // if checkbox is checked, they can proceed to the next page
        // else, they may cannot continue
        if(request.getParameter("checkbox") != null){
            response.sendRedirect(getServletConfig().getInitParameter("SchoolPage"));
        }
        else {
            response.sendRedirect(getServletConfig().getInitParameter("Terms"));
        }
    }
}
