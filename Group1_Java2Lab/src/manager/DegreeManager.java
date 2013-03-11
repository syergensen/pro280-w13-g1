package manager;

import model.Degree;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class DegreeManager
{
    @PersistenceContext
    EntityManager em;

    @PersistenceContext
    static EntityManager sem;

    public static List<Degree> getStaticDegrees()
    {
        TypedQuery<Degree> degreeQuery = sem.createQuery("SELECT d FROM Degree d", Degree.class);
        return degreeQuery.getResultList();
    }

    public List<Degree> getDegrees()
    {
        TypedQuery<Degree> degreeQuery = em.createQuery("SELECT d FROM Degree d", Degree.class);
        return degreeQuery.getResultList();
    }

    public Degree getDegree(Integer id)
    {
        return em.find(Degree.class, id);
    }

    public Degree findDegree(String name)
    {
        TypedQuery<Degree> degreeQuery = em.createQuery("SELECT d FROM Degree d WHERE name="+name, Degree.class);
        return degreeQuery.getSingleResult();
    }

    public Degree create(Degree degree)
    {
        em.persist(degree);
        return degree;
    }

    public Degree update(Degree degree)
    {
        em.merge(degree);
        return degree;
    }

    public void delete(Integer id)
    {
        em.remove(getDegree(id));
    }
}
