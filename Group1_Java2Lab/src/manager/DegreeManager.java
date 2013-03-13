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

    public List<Degree> getDegrees()
    {
        TypedQuery<Degree> degreeQuery = em.createQuery("SELECT d FROM Degree d", Degree.class);
        return degreeQuery.getResultList();
    }

    public Degree getDegree(Integer id)
    {
        return em.find(Degree.class, id);
    }

    public Degree findDegree(String degree)
    {
        TypedQuery<Degree> degreeQuery = em.createQuery("SELECT d FROM Degree d WHERE d.degree = '" + degree + "'", Degree.class);
//        degreeQuery.setParameter("name", degree);
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
