package manager;

import model.Quarter;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acottrill
 * Date: 3/11/13
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@LocalBean
public class QuarterManager {
    @PersistenceContext
    javax.persistence.EntityManager em;

    @PersistenceContext
    static javax.persistence.EntityManager sem;

    public List<Quarter> getQuarters(){
        TypedQuery<Quarter> myList = em.createQuery("SELECT p FROM Quarter p", Quarter.class);
        return myList.getResultList();
    }

    public static List<Quarter> getStaticQuarters(){
        TypedQuery<Quarter> myList = sem.createQuery("SELECT p FROM Quarter p", Quarter.class);
        return myList.getResultList();
    }
}
