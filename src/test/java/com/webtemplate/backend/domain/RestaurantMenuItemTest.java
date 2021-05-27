package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class RestaurantMenuItemTest {

    private static Date testDate = new Date();

    private static RestaurantMenuItem getInstance() {
        return new RestaurantMenuItem().restaurant(RestaurantTest.getInstance()).createdByAccountId("createdByAccountId")
                .createdDate(testDate).modifiedByAccountId("modifiedByAccountId").modifiedDate(testDate)
                .imageId("imageId").menuName("menuName").restaurantMenuItemId("restaurantMenuItemId");
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new RestaurantMenuItem());
    }

    @Test
    void setters() {
        assertDoesNotThrow(RestaurantMenuItemTest::getInstance);
    }

    @Test
    void getters() {
        RestaurantMenuItem item = getInstance();
        assertEquals(item.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(item.getCreatedDate(), testDate);
        assertEquals(item.getImageId(), "imageId");
        assertEquals(item.getMenuName(), "menuName");
        assertEquals(item.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(item.getModifiedDate(), testDate);
        assertTrue(item.getRestaurant().equals(RestaurantTest.getInstance()));
        assertEquals(item.getRestaurantMenuItemId(), "restaurantMenuItemId");
    }
}
