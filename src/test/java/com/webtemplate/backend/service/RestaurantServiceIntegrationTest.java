package com.webtemplate.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.webtemplate.backend.BackendApplicationTests;
import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.repository.RestaurantRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest
public class RestaurantServiceIntegrationTest extends BackendApplicationTests {

    @InjectMocks
    RestaurantService restaurantService;

    @Mock
    RestaurantRepository restaurantDB;

    @Test
    void findByRestaurantId() {
        when(restaurantDB.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002"))
        .thenReturn(BackendApplicationTests.restaurants.get("da215b52-be98-11eb-ba46-0242ac110002"));

        Restaurant one = restaurantService.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
        assertNotNull(one);
        assertEquals(one.getRestaurantId(), "da215b52-be98-11eb-ba46-0242ac110002");

        verify(restaurantDB).findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
    }
}
