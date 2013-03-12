package manager;

import model.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class UserManager {

    @PersistenceContext
    private EntityManager em;

    // gets a list of all the users in the User table
    public List<User> getUsers(){
        TypedQuery<User> query = em.createNamedQuery(User.ALL_USERS_QUERY, User.class);
        return query.getResultList();
    }

    // grabs a user by their username in the User table
    public User getUser(String username){
        TypedQuery<User> query = em.createNamedQuery(User.USER_NAME_QUERY, User.class);
        query.setParameter("name", username);
        List<User> users = query.getResultList();
        if(users != null && users.size() != 0)
            return users.get(0);
        return null;
    }

    // saves the user to the User table when added
    public void saveUser(User user){
        em.persist(user);
    }
}
