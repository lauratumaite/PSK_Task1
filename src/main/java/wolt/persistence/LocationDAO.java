package wolt.persistence;

import wolt.entities.Location;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class LocationDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public void persist(Location location) {
        entityManager.persist(location);
    }
}
