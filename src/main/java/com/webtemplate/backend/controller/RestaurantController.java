package com.webtemplate.backend.controller;

import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.enums.ResponseType;
import com.webtemplate.backend.helper.ApiResponse;
import com.webtemplate.backend.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = { "/", "/{restaurantId}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getRestaurant(@PathVariable(required = false) String restaurantId) {
        if (restaurantId == null) {
            return new ApiResponse(ResponseType.BAD_REQUEST, "no restaurantId has been given");
        }
        Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
        if (restaurant == null) {
            return new ApiResponse(ResponseType.BAD_REQUEST, String.format("no restaurant has been found with %s", restaurantId));
        }
        return new ApiResponse(ResponseType.OK, restaurant);
    }
}
