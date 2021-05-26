package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rest_addrs")
public class RestaurantAddress extends IdDomain<RestaurantAddress> {
    @Id
    @Column(name = "rest_addr_id")
    String restaurantAddressId;

    @Column(name = "strt_addr1")
    String streetAddress1;

    @Column(name = "strt_addr2")
    String streetAddress2;

    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Column(name = "country")
    String country;

    public String getRestaurantAddressId() {
        return this.restaurantAddressId;
    }

    public void setRestaurantAddressId(String restaurantAddressId) {
        this.restaurantAddressId = restaurantAddressId;
    }

    public String getStreetAddress1() {
        return this.streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return this.streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public RestaurantAddress restaurantAddressId(String restaurantAddressId) {
        setRestaurantAddressId(restaurantAddressId);
        return this;
    }

    public RestaurantAddress streetAddress1(String streetAddress1) {
        setStreetAddress1(streetAddress1);
        return this;
    }

    public RestaurantAddress streetAddress2(String streetAddress2) {
        setStreetAddress2(streetAddress2);
        return this;
    }

    public RestaurantAddress city(String city) {
        setCity(city);
        return this;
    }

    public RestaurantAddress state(String state) {
        setState(state);
        return this;
    }

    public RestaurantAddress country(String country) {
        setCountry(country);
        return this;
    }

}
