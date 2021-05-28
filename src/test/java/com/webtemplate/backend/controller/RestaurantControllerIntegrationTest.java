package com.webtemplate.backend.controller;

import com.webtemplate.backend.BackendApplicationTests;
import com.webtemplate.backend.service.RestaurantService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RestaurantControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RestaurantService restaurantService;

    @Test
    void getRestaurantNull() throws Exception {
        mockMvc.perform(get("/restaurant")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("no restaurantId has been given"));
    }

    @Test
    void getRestaurantNotFound() throws Exception {
        when(restaurantService.findByRestaurantId("someRandomString")).thenReturn(null);

        mockMvc.perform(get("/restaurant/someRandomString")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("no restaurant has been found with someRandomString"));

        verify(restaurantService).findByRestaurantId("someRandomString");
    }

    @Test
    void getRestaurant() throws Exception {
        when(restaurantService.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002"))
        .thenReturn(BackendApplicationTests.restaurants.get("da215b52-be98-11eb-ba46-0242ac110002"));

        mockMvc.perform(get("/restaurant/da215b52-be98-11eb-ba46-0242ac110002")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Restaurant(da215b52-be98-11eb-ba46-0242ac110002, parent restaurant)"));

        verify(restaurantService).findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
    }
}
