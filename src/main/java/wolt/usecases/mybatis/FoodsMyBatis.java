package wolt.usecases.mybatis;

import lombok.Getter;
import wolt.mybatis.dao.FoodMapper;
import wolt.mybatis.model.Food;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class FoodsMyBatis implements Serializable {

    @Inject
    private FoodMapper mapper;

    @Getter
    private List<Food> allFoods;

    @PostConstruct
    private void init() {
        loadAllFoods();
    }

    private void loadAllFoods() {
        allFoods = mapper.selectAll();
    }
}
