package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class RestaurantAddressTest {

    private static Date testDate = new Date();

    private static RestaurantAddress getInstance() {
        return new RestaurantAddress().createdByAccountId("createdByAccountId").createdDate(testDate).city("city")
                .country("country").modifiedByAccountId("modifiedByAccountId").modifiedDate(testDate)
                .restaurantAddressId("restaurantAddressId").restaurant(RestaurantTest.getInstance()).state("state")
                .streetAddress1("streetAddress1").streetAddress2("streetAddress2");
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new RestaurantAddress());
    }

    @Test
    void setters() {
        assertDoesNotThrow(RestaurantAddressTest::getInstance);
    }

    @Test
    void getters() {
        RestaurantAddress restaurantAddress = RestaurantAddressTest.getInstance();
        assertEquals(restaurantAddress.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(restaurantAddress.getCreatedDate(), testDate);
        assertEquals(restaurantAddress.getRestaurantAddressId(), "restaurantAddressId");
        assertEquals(restaurantAddress.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(restaurantAddress.getModifiedDate(), testDate);
        assertEquals(restaurantAddress.getCity(), "city");
        assertEquals(restaurantAddress.getCountry(), "country");
        assertTrue(restaurantAddress.getRestaurant().equals(RestaurantTest.getInstance()));
        assertEquals(restaurantAddress.getState(), "state");
        assertEquals(restaurantAddress.getStreetAddress1(), "streetAddress1");
        assertEquals(restaurantAddress.getStreetAddress2(), "streetAddress2");
    }
}
