package wolt.usecases;

import wolt.entities.Restaurant;
import wolt.persistence.RestaurantDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Restaurants implements Serializable {

    @Inject
    private RestaurantDAO restaurantDAO;

    @Getter
    @Setter
    private Restaurant restaurantToCreate = new Restaurant();

    @Getter
    private List<Restaurant> allRestaurants;

    @PostConstruct
    private void init() {
        loadAllRestaurants();
    }

    @Transactional
    public String createRestaurant() {
        restaurantDAO.persist(restaurantToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllRestaurants() {
        this.allRestaurants = restaurantDAO.loadAll();
    }
}
