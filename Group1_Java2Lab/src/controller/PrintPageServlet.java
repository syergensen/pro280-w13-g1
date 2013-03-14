package controller;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "PrintPageServlet", urlPatterns = {"/print"},
        initParams =
                {
                        @WebInitParam(name = "success", value = "WEB-INF/results.jsp")})
public class PrintPageServlet {
}
