package com.webtemplate.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.webtemplate.backend.BackendApplicationTests;
import com.webtemplate.backend.domain.Restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
public class RestaurantRepositoryIntegrationTest {

    @MockBean
    RestaurantRepository restaurantDB;

    @Test
    void findByRestaurantId() {
        when(restaurantDB.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002"))
                .thenReturn(BackendApplicationTests.restaurants
                        .get("da215b52-be98-11eb-ba46-0242ac110002"));

        Restaurant one = restaurantDB.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
        assertNotNull(one);
        assertEquals(one.getRestaurantId(), "da215b52-be98-11eb-ba46-0242ac110002");
    }
}
