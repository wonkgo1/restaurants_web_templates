package com.webtemplate.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.Map;

import com.webtemplate.backend.BackendApplicationTests;
import com.webtemplate.backend.domain.Restaurant;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RestaurantRepositoryUnitTest {

    Map<String, Restaurant> restaurants = BackendApplicationTests.restaurants;

    @Test
    void findByRestaurantId() {
        RestaurantRepository repo = Mockito.mock(RestaurantRepository.class);
        Mockito.when(repo.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002"))
                .thenReturn(restaurants.get("da215b52-be98-11eb-ba46-0242ac110002"));
        Restaurant target = restaurants.get("da215b52-be98-11eb-ba46-0242ac110002");
        Restaurant restaurant = repo.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");

        assertEquals(target.getRestaurantId(), restaurant.getRestaurantId());
        assertEquals(target.getRestaurantName(), restaurant.getRestaurantName());

        verify(repo).findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
    }
}
