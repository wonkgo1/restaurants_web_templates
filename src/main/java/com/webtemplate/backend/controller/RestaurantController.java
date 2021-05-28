package com.webtemplate.backend.controller;

import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestaurantController {

    RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = { "/restaurant", "/restaurant/{restaurantId}" }, method = RequestMethod.GET)
    public String getRestaurant(@PathVariable(required = false) String restaurantId) {
        if (restaurantId == null) {
            return "no restaurantId has been given";
        }
        Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
        if (restaurant == null) {
            return String.format("no restaurant has been found with %s", restaurantId);
        }
        return String.format("Restaurant(%s, %s)", restaurant.getRestaurantId(), restaurant.getRestaurantName());
    }
}
