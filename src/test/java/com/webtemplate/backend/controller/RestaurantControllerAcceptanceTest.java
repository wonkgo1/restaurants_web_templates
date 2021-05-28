package com.webtemplate.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerAcceptanceTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getRestaurantNull() throws Exception {
        mockMvc.perform(get("/restaurant/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseType").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.returnObject").value("no restaurantId has been given"));
    }

    @Test
    void getRestaurantNotFound() throws Exception {
        mockMvc.perform(get("/restaurant/someRandomString"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseType").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.returnObject").value("no restaurant has been found with someRandomString"));
    }

    @Test
    void getRestaurant() throws Exception {
        mockMvc.perform(get("/restaurant/da215b52-be98-11eb-ba46-0242ac110002"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseType").value("OK"))
                .andExpect(jsonPath("$.returnObject.restaurantId").value("da215b52-be98-11eb-ba46-0242ac110002"))
                .andExpect(jsonPath("$.returnObject.restaurantName").value("parent restaurant"));
    }
}
