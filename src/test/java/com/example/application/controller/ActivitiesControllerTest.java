package com.example.application.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.application.error.ActivityNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Objects;

@SpringBootTest
class ActivitiesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ActivitiesController activitiesController;

    @Test
    void testGetActivities() {
        var result = activitiesController.activities();
        assertNotNull(result);
    }

    @Test
    void testGetActivityByID() {
        var result = activitiesController.activities(40881L);
        assertTrue(Objects.requireNonNull(result.getBody()).getTitle().contains("TV Tower"));
    }

    @Test
    void testGetActivityByID2() {
        assertThrows(ActivityNotFound.class,() ->activitiesController.activities(4081L) );
    }

    @Test
    void testGetActivitiesOK() {
        var result = activitiesController.activities();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}
