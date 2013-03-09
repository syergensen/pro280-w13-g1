package manager;

import model.DebtType;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class DebtTypeManager
{
    @PersistenceContext
    EntityManager em;

    public List<DebtType> getDebtTypes()
    {
        TypedQuery<DebtType> debtTypeQuery = em.createQuery("SELECT d FROM DebtType d", DebtType.class);
        return debtTypeQuery.getResultList();
    }

    public DebtType getDebtTypes(Integer id)
    {
        return em.find(DebtType.class, id);
    }

    public DebtType create(DebtType debtType)
    {
        em.persist(debtType);
        return debtType;
    }

    public DebtType update(DebtType debtType)
    {
        em.merge(debtType);
        return debtType;
    }

    public void delete(Integer id)
    {
        em.remove(getDebtTypes(id));
    }
}
