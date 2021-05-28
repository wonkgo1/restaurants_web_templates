package com.webtemplate.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.webtemplate.backend.domain.Restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantRepositoryAcceptanceTest {

    @Autowired
    RestaurantRepository restaurantDB;

    @Test
    void findByRestaurantId() {
        Restaurant one = restaurantDB.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
        assertNotNull(one);
        assertEquals(one.getRestaurantId(), "da215b52-be98-11eb-ba46-0242ac110002");
    }
}
