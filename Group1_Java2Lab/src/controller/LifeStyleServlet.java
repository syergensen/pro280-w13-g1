package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: acottrill
 * Date: 3/11/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "lifeStyle", urlPatterns = {"/lifeStyle"})
public class LifeStyleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        for(String s : new String[]{
                "quarter",
                "year",
                "degree",
                "extra-quarter-full",
                "extra-quarter-part",
                "loan-percent"}){
            session.setAttribute(s, request.getAttribute(s));
        }
        for(int i = 1; request.getAttribute("debt" + i) != null; i++){
            request.setAttribute("debt" + i, "debt" + i);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/lifeStyle.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
