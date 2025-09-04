package com.example.application.service;

import com.example.application.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    /**
     * Lists all the available activities
     * @return list of activities
     */
    List<ActivityDto> listAllActivities();

    /**
     * Get activity by id
     * @param activityId
     * @return activity
     */
    ActivityDto getActivityById(Long activityId);

    /**
     * Search all activities matching the input parameter
     * @param search
     * @return list of activities
     */
    List<ActivityDto> searchActivities(String search);

}
