package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AccountTest {

    private static Date testDate = new Date();

    private static Account getInstance() {
        return new Account().accountId("accountId").createdByAccountId("createdByAccountId").createdDate(testDate)
                .modifiedByAccountId("modifiedByAccountId").modifiedDate(testDate)
                .restaurant(RestaurantTest.getInstance());
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new Account());
    }

    @Test
    void setters() {
        assertDoesNotThrow(AccountTest::getInstance);
    }

    @Test
    void getters() {
        var account = AccountTest.getInstance();
        assertEquals(account.getAccountId(), "accountId");
        assertEquals(account.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(account.getCreatedDate(), testDate);
        assertEquals(account.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(account.getModifiedDate(), testDate);
        assertTrue(account.getRestaurant().equals(RestaurantTest.getInstance()));
    }
}
