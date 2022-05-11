package wolt.persistence;

import lombok.Setter;
import wolt.entities.Restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RestaurantDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public List<Restaurant> loadAll() {
        return entityManager.createNamedQuery("Restaurant.findAll", Restaurant.class).getResultList();
    }

    public void persist(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }

    public Restaurant findOne(int id) {
        return entityManager.find(Restaurant.class, id);
    }

    public void update(Restaurant restaurant) {
        entityManager.merge(restaurant);
    }
}
