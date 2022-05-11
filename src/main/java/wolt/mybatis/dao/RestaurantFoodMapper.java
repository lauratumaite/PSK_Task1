package wolt.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import wolt.mybatis.model.RestaurantFood;

@Mapper
public interface RestaurantFoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT_FOOD
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    int insert(RestaurantFood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.RESTAURANT_FOOD
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    List<RestaurantFood> selectAll();
}