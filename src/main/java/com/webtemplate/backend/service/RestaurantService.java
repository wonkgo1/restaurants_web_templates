package com.webtemplate.backend.service;

import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    RestaurantRepository restaurantDB;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantDB) {
        this.restaurantDB = restaurantDB;
    }

    public Restaurant findByRestaurantId(@NonNull final String restaurantId) {
        return restaurantDB.findByRestaurantId(restaurantId);
    }
}
