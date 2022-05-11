package wolt.usecases;

import wolt.entities.Food;
import wolt.persistence.FoodDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Foods implements Serializable {

    @Inject
    private FoodDAO dao;

    @Getter
    private List<Food> allFoods;

    @PostConstruct
    private void init() {
        loadAllFoods();
    }

    private void loadAllFoods() {
        allFoods = dao.findAll();
    }


}
