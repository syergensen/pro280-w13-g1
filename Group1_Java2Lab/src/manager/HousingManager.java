package manager;

import model.Housing;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class HousingManager
{
    @PersistenceContext
    EntityManager em;

    public List<Housing> getHousings()
    {
        TypedQuery<Housing> housingQuery = em.createQuery("SELECT h FROM Housing h", Housing.class);
        return housingQuery.getResultList();
    }

    public Housing getHousing(Integer id)
    {
        return em.find(Housing.class, id);
    }

    public Housing create(Housing housing)
    {
        em.persist(housing);
        return housing;
    }

    public Housing update(Housing housing)
    {
        em.merge(housing);
        return housing;
    }

    public void delete(Integer id)
    {
        em.remove(getHousing(id));
    }
}
