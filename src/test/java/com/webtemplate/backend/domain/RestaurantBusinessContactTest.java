package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class RestaurantBusinessContactTest {

    private static Date testDate = new Date();

    private static RestaurantBusinessContact getInstance() {
        return new RestaurantBusinessContact().createdByAccountId("createdByAccountId").createdDate(testDate)
                .email("email").firstName("firstName").lastName("lastName").modifiedByAccountId("modifiedByAccountId")
                .modifiedDate(testDate).phone("phone").restaurantBusinessContactId("restaurantBusinessContactId")
                .restaurantId("restaurantId").title("title");
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new RestaurantBusinessContact());
    }

    @Test
    void setters() {
        assertDoesNotThrow(RestaurantBusinessContactTest::getInstance);
    }

    @Test
    void getters() {
        RestaurantBusinessContact busContact = getInstance();
        assertEquals(busContact.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(busContact.getCreatedDate(), testDate);
        assertEquals(busContact.getEmail(), "email");
        assertEquals(busContact.getFirstName(), "firstName");
        assertEquals(busContact.getLastName(), "lastName");
        assertEquals(busContact.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(busContact.getModifiedDate(), testDate);
        assertEquals(busContact.getPhone(), "phone");
        assertEquals(busContact.getRestaurantBusinessContactId(), "restaurantBusinessContactId");
        assertEquals(busContact.getRestaurantId(), "restaurantId");
        assertEquals(busContact.getTitle(), "title");
    }
}
