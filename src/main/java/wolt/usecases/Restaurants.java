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
import java.util.ArrayList;
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

    private void loadAllRestaurants() {this.allRestaurants = restaurantDAO.loadAll();    }

    @Getter
    private List<Restaurant> filteredRestaurants;

    @Transactional
    public String filterRestaurants() {
        this.allRestaurants = restaurantDAO.loadAll();
        List<Restaurant> filtered = new ArrayList<>();

        for(Restaurant restaurant : allRestaurants)
        {
            if(restaurant.getFoods().size() > 4)
            {
                filtered.add(restaurant);
            }
        }
        this.filteredRestaurants = filtered;
        return "PSK1/index?faces-redirect=true";
    }
}
