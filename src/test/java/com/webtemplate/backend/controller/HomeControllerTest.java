package com.webtemplate.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HomeControllerTest {
    
    @Test
    void home() {
        HomeController controller = new HomeController();
        String welcomeMsg = controller.home();
        assertEquals("Hello from WebTemplate", welcomeMsg);
    }
}
