package wolt.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Restaurant {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RESTAURANT.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.RESTAURANT.TITLE
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RESTAURANT.ID
     *
     * @return the value of PUBLIC.RESTAURANT.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RESTAURANT.ID
     *
     * @param id the value for PUBLIC.RESTAURANT.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.RESTAURANT.TITLE
     *
     * @return the value of PUBLIC.RESTAURANT.TITLE
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.RESTAURANT.TITLE
     *
     * @param title the value for PUBLIC.RESTAURANT.TITLE
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setTitle(String title) {
        this.title = title;
    }

    private List<Location> locations;
    private List<Food> foods;
}