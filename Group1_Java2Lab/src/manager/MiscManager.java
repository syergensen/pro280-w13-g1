package manager;

import model.Misc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class MiscManager
{
    @PersistenceContext
    EntityManager em;

    public List<Misc> getMiscs()
    {
        TypedQuery<Misc> miscQuery = em.createQuery("SELECT m FROM Misc m", Misc.class);
        return miscQuery.getResultList();
    }

    public Misc getMisc(Integer id)
    {
        return em.find(Misc.class, id);
    }

    public Misc create(Misc misc)
    {
        em.persist(misc);
        return misc;
    }

    public Misc update(Misc misc)
    {
        em.merge(misc);
        return misc;
    }

    public void delete(Integer id)
    {
        em.remove(getMisc(id));
    }
}
