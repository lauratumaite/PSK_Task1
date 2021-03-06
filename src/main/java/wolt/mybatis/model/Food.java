package wolt.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Food {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FOOD.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.FOOD.NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FOOD.ID
     *
     * @return the value of PUBLIC.FOOD.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FOOD.ID
     *
     * @param id the value for PUBLIC.FOOD.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.FOOD.NAME
     *
     * @return the value of PUBLIC.FOOD.NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.FOOD.NAME
     *
     * @param name the value for PUBLIC.FOOD.NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    private List<Restaurant> restaurants;
}