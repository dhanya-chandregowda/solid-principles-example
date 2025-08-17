package com.example.application.service;

import com.example.application.controller.SupplierController;
import com.example.application.error.ActivityNotFound;
import com.example.application.mapper.ActivityMapper;
import com.example.application.repository.ActivityRepository;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.getourguide.interview.helpers.ActivityHelper.createActivity;
import static com.getourguide.interview.helpers.SupplierHelper.createSupplier;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivityServiceTest {
    private ActivityRepository activityRepository;
    private ActivityMapper activityMapper;
    private SupplierController supplierController;
    private ActivityService activityService;

    @BeforeEach
    void setup() {
        this.activityRepository = mock(ActivityRepository.class);
        this.activityMapper =new ActivityMapper();
        this.supplierController = mock(SupplierController.class);
        this.activityService = new ActivityService(activityRepository,activityMapper);
    }

    @Test
    void testGetActivities() {
        var testActivity = createActivity(
            1L,
            "Test Activity",
            100,
            5.0,
            false,
            createSupplier(1L, "Test Supplier")
        );
        when(activityRepository.findAll()).thenReturn(List.of(testActivity));

        var result = activityService.listAllActivities();

        assertNotNull(result);
    }

    @Test
    void testGetActivityById() {
        var testActivity = createActivity(
                2L,
                "Test Activity",
                100,
                5.0,
                false,
                createSupplier(3L, "Test Supplier")
        );
        when(activityRepository.findById(2L)).thenReturn(Optional.of(testActivity));

        var result = activityService.getActivityById(2L);

        assertNotNull(result);
        assertEquals("Test Activity",result.getTitle());
    }

    @Test
    void testGetActivityNotFound() {
        when(activityRepository.findById(1L)).thenThrow(ActivityNotFound.class);

        assertThrows(ActivityNotFound.class, () ->activityService.getActivityById(1L));
    }

    @Test
    void listAllActivitiesReturnsEmptyListWhenNoActivitiesExist() {
        when(activityRepository.findAll()).thenReturn(Collections.emptyList());

        var result = activityService.listAllActivities();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void searchActivitiesReturnsMatchingActivities() {
        var testActivity1 = createActivity(
                1L,
                "Hiking Adventure",
                100,
                4.5,
                false,
                createSupplier(1L, "Supplier A")
        );
        var testActivity2 = createActivity(
                2L,
                "City Tour",
                50,
                4.0,
                false,
                createSupplier(2L, "Supplier B")
        );
        when(activityRepository.findAll()).thenReturn(List.of(testActivity1, testActivity2));

        var result = activityService.searchActivities("Hiking");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Hiking Adventure", result.get(0).getTitle());
    }

    @Test
    void searchActivitiesReturnsEmptyListWhenNoMatchFound() {
        var testActivity = createActivity(
                1L,
                "Hiking Adventure",
                100,
                4.5,
                false,
                createSupplier(1L, "Supplier A")
        );
        when(activityRepository.findAll()).thenReturn(List.of(testActivity));

        var result = activityService.searchActivities("Swimming");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
