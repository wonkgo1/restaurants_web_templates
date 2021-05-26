package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rests")
public class Restaurant extends BaseDomain<Restaurant> {
    @Id
    @Column(name = "rest_id")
    String restaurantId;
    @Column(name = "rest_nm")
    String restaurantName;
    @Column(name = "parnt_rest_id")
    String parentRestaurantId;
    @Column(name = "url")
    String url;


    public String getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getParentRestaurantId() {
        return this.parentRestaurantId;
    }

    public void setParentRestaurantId(String parentRestaurantId) {
        this.parentRestaurantId = parentRestaurantId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Restaurant restaurantId(String restaurantId) {
        setRestaurantId(restaurantId);
        return this;
    }

    public Restaurant restaurantName(String restaurantName) {
        setRestaurantName(restaurantName);
        return this;
    }

    public Restaurant parentRestaurantId(String parentRestaurantId) {
        setParentRestaurantId(parentRestaurantId);
        return this;
    }

    public Restaurant url(String url) {
        setUrl(url);
        return this;
    }

}
