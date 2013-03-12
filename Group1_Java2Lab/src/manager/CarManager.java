package manager;

import model.Car;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean

public class CarManager
{
    @PersistenceContext
    EntityManager em;

    public List<Car> getCars()
    {
        TypedQuery<Car> carQuery = em.createQuery("SELECT c FROM Car c", Car.class);
        return carQuery.getResultList();
    }

    public Car findCar(String condition, String quality)
    {
        TypedQuery<Car> carQuery = em.createQuery("SELECT c FROM Car c WHERE condition = " + condition + ", quality = " + quality, Car.class);
        return carQuery.getSingleResult();

    }

    public Car getCar(Integer id)
    {
        return em.find(Car.class, id);
    }

    public Car create(Car car)
    {
        em.persist(car);
        return car;
    }

    public Car update(Car car)
    {
        em.merge(car);
        return car;
    }

    public void delete(Integer id)
    {
        em.remove(getCar(id));
    }
}
