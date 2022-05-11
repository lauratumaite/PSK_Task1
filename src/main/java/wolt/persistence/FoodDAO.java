package wolt.persistence;

import wolt.entities.Food;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class FoodDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public void persist(Food food) {
        entityManager.persist(food);
    }

    public List<Food> findAll() {
        return entityManager.createNamedQuery("Food.findAll", Food.class).getResultList();
    }

    public Food findByName(String name) {
        try {
            Query query = entityManager.createNamedQuery("Food.findByName");
            query.setParameter("name", name);
            return (Food) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void update(Food food) {
        entityManager.merge(food);
    }
}
