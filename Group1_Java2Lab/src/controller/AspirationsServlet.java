package controller;

import manager.DebtTypeManager;
import manager.RegionManager;
import model.Housing;

import javax.ejb.EJB;
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
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "aspirations", urlPatterns = {"/aspirations"})
public class AspirationsServlet extends HttpServlet {

    @EJB
    private DebtTypeManager dtm;

    @EJB
    private RegionManager rm;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        for(String s : new String[]{
                "input_bills",
                "go_out_to_lunch",
                "go_out_to_dinner",
                "spend_on_video_games"
        }){
            session.setAttribute(s, request.getAttribute(s));
        }

        Housing h = (Housing) request.getAttribute("housing_situation");
        if(h == null){
            session.setAttribute("input_rent", request.getAttribute("input_rent"));
            session.setAttribute("input_utilities", request.getAttribute("input_bills"));
        }else{
            session.setAttribute("input_rent", h.getRent());
            session.setAttribute("input_utilities", h.getUtilities());
        }
        request.setAttribute("all_regions", rm.getRegions());
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultCalculator");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
