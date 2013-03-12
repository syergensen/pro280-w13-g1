package manager;

import model.DegreeRegionSalary;
import model.DegreeRegionSalary;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class DegreeRegionSalaryManager
{
    @PersistenceContext
    EntityManager em;

    public List<DegreeRegionSalary> getDegreeRegionSalaries()
    {
        TypedQuery<DegreeRegionSalary> drsQuery = em.createQuery("SELECT drs FROM Degree_Region_Salary drs", DegreeRegionSalary.class);
        return drsQuery.getResultList();
    }

    public DegreeRegionSalary getDegreeRegionSalary(Integer degreeId, Integer regionId)
    {
        TypedQuery<DegreeRegionSalary> drsQuery = em.createQuery("SELECT drs FROM Degree_Region_Salary drs WHERE degree_id = " + degreeId + " AND region_id = " + regionId, DegreeRegionSalary.class);
        return drsQuery.getSingleResult();
    }

    public DegreeRegionSalary create(DegreeRegionSalary drs)
    {
        em.persist(drs);
        return drs;
    }

    public DegreeRegionSalary update(DegreeRegionSalary drs)
    {
        em.merge(drs);
        return drs;
    }

    public void delete(Integer degreeId, Integer regionId)
    {
        em.remove(getDegreeRegionSalary(degreeId, regionId));
    }


}
