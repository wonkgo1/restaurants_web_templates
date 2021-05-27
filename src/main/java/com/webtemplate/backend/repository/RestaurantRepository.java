package com.webtemplate.backend.repository;

import com.webtemplate.backend.domain.Restaurant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {

    Restaurant findByRestaurantId(String restaurantId);
    
}
