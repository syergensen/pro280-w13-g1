package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/6/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
//@WebFilter("/*")
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Principal userPrincipal = request.getUserPrincipal();
        String path = request.getServletPath();

        // redirect the user if they are not logged in, unless they're in the process of logging in
        if(userPrincipal == null && !"/login".equals(request.getServletPath())){
            String fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            ((HttpServletResponse) resp).sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=" + fullPath + "/login");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
