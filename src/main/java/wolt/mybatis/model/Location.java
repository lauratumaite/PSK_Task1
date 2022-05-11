package wolt.mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.LOCATION.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.LOCATION.FULL_NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private String fullName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.LOCATION.RESTAURANT_ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    private Integer restaurantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.LOCATION.ID
     *
     * @return the value of PUBLIC.LOCATION.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.LOCATION.ID
     *
     * @param id the value for PUBLIC.LOCATION.ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.LOCATION.FULL_NAME
     *
     * @return the value of PUBLIC.LOCATION.FULL_NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.LOCATION.FULL_NAME
     *
     * @param fullName the value for PUBLIC.LOCATION.FULL_NAME
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.LOCATION.RESTAURANT_ID
     *
     * @return the value of PUBLIC.LOCATION.RESTAURANT_ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public Integer getRestaurantId() {
        return restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.LOCATION.RESTAURANT_ID
     *
     * @param restaurantId the value for PUBLIC.LOCATION.RESTAURANT_ID
     *
     * @mbg.generated Tue May 10 00:52:59 EEST 2022
     */
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    private Restaurant restaurant;
}