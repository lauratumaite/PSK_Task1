package wolt.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import wolt.mybatis.dao.FoodMapper;
import wolt.mybatis.dao.RestaurantFoodMapper;
import wolt.mybatis.dao.RestaurantMapper;
import wolt.mybatis.model.Food;
import wolt.mybatis.model.Restaurant;
import wolt.mybatis.model.RestaurantFood;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import static javax.faces.context.FacesContext.getCurrentInstance;

@Model
public class LocationsForRestaurantsMyBatis implements Serializable {

    @Inject
    private RestaurantMapper restaurantMapper;

    @Inject
    private FoodMapper foodMapper;

    @Inject
    private RestaurantFoodMapper restaurantFoodMapper;

    @Getter
    @Setter
    private Restaurant restaurant;

    @Getter
    @Setter
    private Food foodToAdd = new Food();

    @Transactional
    public String addFoodsToRestaurant() {
        foodMapper.insert(foodToAdd);
        Food createdFood = foodMapper.findByName(foodToAdd.getName());
        RestaurantFood restaurantFood = new RestaurantFood();
        restaurantFood.setRestaurantId(this.restaurant.getId());
        restaurantFood.setFoodId(createdFood.getId());
        restaurantFoodMapper.insert(restaurantFood);
        return "restaurants?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        int restaurantId = Integer.parseInt(requestParams.get("restaurantId"));
        this.restaurant = restaurantMapper.selectByPrimaryKey(restaurantId);
    }
}
