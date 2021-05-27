package com.webtemplate.backend.service;

import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.repository.RestaurantRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    
    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    RestaurantRepository restaurantDB;

    public Restaurant findByRestaurantId(@NonNull final String restaurantId) {
        return restaurantDB.findByRestaurantId(restaurantId);
    }
}
