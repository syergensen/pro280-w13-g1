package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddQuarterServlet", urlPatterns = {"/addquarter"},
        initParams =
                {
                        @WebInitParam(name = "success", value = "WEB-INF/results.jsp")})
public class AddQuarterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        Double extraQuarter = Double.parseDouble((String)session.getAttribute("extraQuarter"));
        extraQuarter += 1;

        session.setAttribute("extraQuarter", extraQuarter);

        request.getRequestDispatcher(getServletConfig().getInitParameter("success")).forward(request, response);
    }
}
