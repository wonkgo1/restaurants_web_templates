package com.webtemplate.backend.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ImageTest {

    private static Date testDate = new Date();

    private static Image getInstance() {
        return new Image().createdByAccountId("createdByAccountId").createdDate(testDate).imageId("imageId")
                .modifiedByAccountId("modifiedByAccountId").modifiedDate(testDate).url("url");
    }

    @Test
    void constructor() {
        assertDoesNotThrow(() -> new Image());
    }

    @Test
    void setters() {
        assertDoesNotThrow(ImageTest::getInstance);
    }

    @Test
    void getters() {
        Image image = ImageTest.getInstance();
        assertEquals(image.getCreatedByAccountId(), "createdByAccountId");
        assertEquals(image.getCreatedDate(), testDate);
        assertEquals(image.getImageId(), "imageId");
        assertEquals(image.getModifiedByAccountId(), "modifiedByAccountId");
        assertEquals(image.getModifiedDate(), testDate);
        assertEquals(image.getUrl(), "url");
    }
}
