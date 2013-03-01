import controller.Quarter;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acottrill
 * Date: 3/1/13
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@LocalBean
public class myClass {

    @PersistenceContext
    EntityManager em;

    public List<Quarter> getQuarters(){

        TypedQuery<Quarter> playerQuery = em.createQuery("SELECT p FROM controller.Quarter p", Quarter.class);
        return playerQuery.getResultList();
    }
}
