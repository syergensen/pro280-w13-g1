package controller;

import crypto.Encryption;
import crypto.EncryptionType;
import manager.GroupManager;
import manager.UserManager;
import model.Group;
import model.User;
import sun.security.krb5.EncryptionKey;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 2/26/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @EJB
    UserManager userManager;
    @EJB
    GroupManager groupManager;

    private static final String DUMMY_PASSWORD = "dummypassword";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect the user to login with the NUID Authentication Service
        String fullPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        String context = request.getContextPath();

        try{
            String username = request.getParameter("username");
            String role = request.getParameter("role");

             Group group = groupManager.getGroup(role);
             if(group == null){
                 group = new Group();
                 group.setName(role);
                 groupManager.saveGroup(group);
             }

             User user = userManager.getUser(username);
             if(user == null){
                 user = new User();
                 user.setName(username);
                 user.setPassword(Encryption.digest(DUMMY_PASSWORD, EncryptionType.MD5));
                 Set<Group> groups = new HashSet<Group>();
                 groups.add(group);
                 userManager.saveUser(user);
             }

            request.logout();
            request.login(username, DUMMY_PASSWORD);
//            response.sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=" + fullPath + "/terms");
             response.sendRedirect(request.getContextPath());
        }catch(ServletException e){
            response.sendRedirect("http://my.neumont.edu/nuid/service.aspx?ReturnUrl=" + fullPath + "/login");
         }
    }
}
