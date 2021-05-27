package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class RestaurantTest {

    private static Date testDate = new Date();

    public static Restaurant getInstance() {
        return new Restaurant().restaurantId("restaurantId").createdByAccountId("createdByAccountId")
                .createdDate(testDate).modifiedByAccountId("modifiedByAccountId").modifiedDate(testDate)
                .parentRestaurantId("parentRestaurantId").restaurantName("restaurantName").url("url");
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new Restaurant());
    }

    @Test
    void setters() {
        assertDoesNotThrow(RestaurantTest::getInstance);
    }

    @Test
    void getters() {
        Restaurant rest = getInstance();
        assertEquals(rest.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(rest.getCreatedDate(), testDate);
        assertEquals(rest.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(rest.getModifiedDate(), testDate);
        assertEquals(rest.getRestaurantId(), "restaurantId");
        assertEquals(rest.getParentRestaurantId(), "parentRestaurantId");
        assertEquals(rest.getRestaurantName(), "restaurantName");
        assertEquals(rest.getUrl(), "url");
    }

    @Test
    void equals() {
        Restaurant one = RestaurantTest.getInstance();
        Restaurant other = new Restaurant().restaurantId(one.getRestaurantId());
        assertTrue(one.equals(other));
    }
}
