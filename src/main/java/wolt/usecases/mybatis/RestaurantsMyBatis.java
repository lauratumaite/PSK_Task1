package wolt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import wolt.mybatis.dao.RestaurantMapper;
import wolt.mybatis.model.Restaurant;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class RestaurantsMyBatis implements Serializable {

    @Inject
    private RestaurantMapper restaurantMapper;

    @Getter
    private List<Restaurant> allRestaurants;

    @Getter
    @Setter
    private Restaurant restaurantToCreate = new Restaurant();

    @PostConstruct
    private void init() {
        loadAllRestaurants();
    }

    @Transactional
    public String createRestaurant() {
        restaurantMapper.insert(restaurantToCreate);
        return "/myBatis/restaurants?faces-redirect=true";
    }

    private void loadAllRestaurants() {
        allRestaurants = restaurantMapper.selectAll();
    }
}
