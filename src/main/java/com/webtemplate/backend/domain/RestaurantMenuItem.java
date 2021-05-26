package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rest_men_itms")
public class RestaurantMenuItem extends IdDomain<RestaurantMenuItem> {
    @Id
    @Column(name = "rest_men_itm_id")
    String restaurantMenuItemId;
    @Column(name = "men_nm")
    String menuName;
    @Column(name = "img_id")
    String imageId;

    public String getRestaurantMenuItemId() {
        return this.restaurantMenuItemId;
    }

    public void setRestaurantMenuItemId(String restaurantMenuItemId) {
        this.restaurantMenuItemId = restaurantMenuItemId;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getImageId() {
        return this.imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public RestaurantMenuItem restaurantMenuItemId(String restaurantMenuItemId) {
        setRestaurantMenuItemId(restaurantMenuItemId);
        return this;
    }

    public RestaurantMenuItem menuName(String menuName) {
        setMenuName(menuName);
        return this;
    }

    public RestaurantMenuItem imageId(String imageId) {
        setImageId(imageId);
        return this;
    }

}
