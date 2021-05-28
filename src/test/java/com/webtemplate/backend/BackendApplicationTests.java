package com.webtemplate.backend;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.webtemplate.backend.domain.Restaurant;

public class BackendApplicationTests {

    public static Map<String, Restaurant> restaurants;

    static Map<String, Restaurant> initRestaurants() {
        Restaurant one = new Restaurant()
                .restaurantId("da215b52-be98-11eb-ba46-0242ac110002")
                .createdByAccountId("f09fd528-be98-11eb-ba46-0242ac110002")
                .createdDate(new Date())
                .restaurantName("parent restaurant")
                .url("http://localhost:8080/parent_restaurant");

        Restaurant two = new Restaurant()
                .restaurantId("da8eb719-be98-11eb-ba46-0242ac110002")
                .createdByAccountId("f09fd528-be98-11eb-ba46-0242ac110002")
                .createdDate(new Date())
                .restaurantName("child restaurant")
                .url("http://localhost:8080/child_restaurant")
                .parentRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");

        return new HashMap<String, Restaurant>() {
            {
                put("da215b52-be98-11eb-ba46-0242ac110002", one);
                put("da8eb719-be98-11eb-ba46-0242ac110002", two);
            }
        };
    }

    static {
        restaurants = initRestaurants();
    }
}
