package wolt.usecases;

import wolt.entities.Food;
import wolt.entities.Location;
import wolt.entities.Restaurant;
import wolt.persistence.RestaurantDAO;
import wolt.persistence.FoodDAO;
import wolt.persistence.LocationDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static javax.faces.context.FacesContext.getCurrentInstance;

@Model
public class LocationForRestaurant implements Serializable {

    @Inject
    private RestaurantDAO restaurantDAO;

    @Inject
    private LocationDAO locationDAO;

    @Inject
    private FoodDAO foodDAO;

    @Getter
    @Setter
    private Restaurant restaurant;

    @Getter
    @Setter
    private Location locationToCreate = new Location();

    @Getter
    @Setter
    private Food foodToAdd = new Food();

    @Getter
    @Setter
    private List<SelectItem> allFood;

    @Transactional
    public String createLocation() {
        locationToCreate.setRestaurant(this.restaurant);
        locationDAO.persist(locationToCreate);
        return "locations?faces-redirect=true&restaurantId=" + this.restaurant.getId();
    }

    @Transactional
    public String createFood() {
        Food foundFood = foodDAO.findByName(foodToAdd.getName());
        if (isNull(foundFood)) {
            handleNewFood();
        } else {
            handleExistingFood(foundFood);
        }

        return "index?faces-redirect=true";
    }

    private void handleExistingFood(Food foundFood) {
        foodToAdd.setId(foundFood.getId());
        List<Restaurant> allFoodRestaurants = foundFood.getRestaurants();
        allFoodRestaurants.add(this.restaurant);
        foodToAdd.setRestaurants(allFoodRestaurants);
        foodDAO.update(foodToAdd);
    }

    private void handleNewFood() {
        List<Restaurant> allFoodRestaurant = new ArrayList<>();
        allFoodRestaurant.add(this.restaurant);
        foodToAdd.setRestaurants(allFoodRestaurant);
        foodDAO.persist(foodToAdd);
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();


        int restaurantId = Integer.parseInt(requestParams.get("restaurantId"));
        this.restaurant = restaurantDAO.findOne(restaurantId);
        this.allFood = new ArrayList<>();
        List<Food> availableFoods = foodDAO.findAll();
        for (Food food : availableFoods) {
            this.allFood.add(new SelectItem(food, food.getName()));
        }
    }
}
