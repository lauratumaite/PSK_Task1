package wolt.persistence;

import wolt.entities.Location;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class LocationDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public void persist(Location location) {

        entityManager.persist(location);
    }

    public Location findOne(int id) {
        return entityManager.find(Location.class, id);
    }

    public Location update(Location location) {
        return entityManager.merge(location);
    }
}
