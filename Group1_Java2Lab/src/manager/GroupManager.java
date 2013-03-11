package manager;

import model.Group;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/8/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@LocalBean
public class GroupManager {

    @PersistenceContext
    private EntityManager em;

    public Group getGroup(String groupName){
        TypedQuery<Group> query = em.createNamedQuery(Group.GROUP_BY_GROUP_NAME_QUERY, Group.class);
        query.setParameter("name", groupName);
        List<Group> groups = query.getResultList();
        if(groups != null && groups.size() != 0)
            return groups.get(0);
        return null;
    }

    public void saveGroup(Group group){
        em.persist(group);
    }
}
