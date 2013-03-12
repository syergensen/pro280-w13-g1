package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    // This filter is for making sure the user is logged in before trying to access any pages within the site.
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Principal userPrincipal = request.getUserPrincipal();

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
