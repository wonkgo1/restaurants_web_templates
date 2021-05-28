package com.webtemplate.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.webtemplate.backend.BackendApplicationTests;
import com.webtemplate.backend.domain.Restaurant;
import com.webtemplate.backend.service.RestaurantService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RestaurantControllerUnitTest {

    @Test
    void getRestaurantNull() {
        RestaurantService service = Mockito.mock(RestaurantService.class);
        RestaurantController controller = new RestaurantController(service);
        String msg = controller.getRestaurant(null);

        assertEquals("no restaurantId has been given", msg);
    }

    @Test
    void getRestaurantNotFound() {
        RestaurantService service = Mockito.mock(RestaurantService.class);
        Mockito.when(service.findByRestaurantId("some random string")).thenReturn(null);
        RestaurantController controller = new RestaurantController(service);
        String msg = controller.getRestaurant("some random string");

        assertEquals("no restaurant has been found with some random string", msg);

        verify(service).findByRestaurantId("some random string");
    }

    @Test
    void getRestaurant() {
        Restaurant target =
                BackendApplicationTests.restaurants.get("da215b52-be98-11eb-ba46-0242ac110002");

        RestaurantService service = Mockito.mock(RestaurantService.class);
        Mockito.when(service.findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002"))
                .thenReturn(target);

        RestaurantController controller = new RestaurantController(service);
        String msg = controller.getRestaurant("da215b52-be98-11eb-ba46-0242ac110002");

        assertEquals("Restaurant(da215b52-be98-11eb-ba46-0242ac110002, parent restaurant)", msg);

        verify(service).findByRestaurantId("da215b52-be98-11eb-ba46-0242ac110002");
    }
}
