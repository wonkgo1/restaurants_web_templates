package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rest_bus_cntcts")
public class RestaurantBusinessContact extends IdDomain<RestaurantBusinessContact> {
    @Id
    @Column
    String restaurantBusinessContactId;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "title")
    String title;
    @Column(name = "phone")
    String phone;
    @Column(name = "email")
    String email;

    public String getRestaurantBusinessContactId() {
        return this.restaurantBusinessContactId;
    }

    public void setRestaurantBusinessContactId(String restaurantBusinessContactId) {
        this.restaurantBusinessContactId = restaurantBusinessContactId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RestaurantBusinessContact restaurantBusinessContactId(String restaurantBusinessContactId) {
        setRestaurantBusinessContactId(restaurantBusinessContactId);
        return this;
    }

    public RestaurantBusinessContact firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public RestaurantBusinessContact lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public RestaurantBusinessContact title(String title) {
        setTitle(title);
        return this;
    }

    public RestaurantBusinessContact phone(String phone) {
        setPhone(phone);
        return this;
    }

    public RestaurantBusinessContact email(String email) {
        setEmail(email);
        return this;
    }

}
