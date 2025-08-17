package com.example.application.service;

import com.example.application.dto.ActivityDto;
import com.example.application.entity.Activity;
import com.example.application.error.ActivityNotFound;
import com.example.application.mapper.ActivityMapper;
import com.example.application.repository.ActivityRepository;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    private final ActivityMapper activityMapper;

    public List<ActivityDto> listAllActivities() {
        List<ActivityDto> result = new ArrayList<>();
        List<Activity> activities = activityRepository.findAll();

        if(!activities.isEmpty()) {
            result = activities.stream().map(activityMapper::toDTO).toList();
        }
        return result;
    }

    public ActivityDto getActivityById(Long activityId) {
        Activity activity = activityRepository.findById(activityId).orElseThrow(()-> new ActivityNotFound("Not found"));
        return activityMapper.toDTO(activity);
    }

    public List<ActivityDto> searchActivities(String search) {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> result = new ArrayList<>();
        if(!activities.isEmpty()) {
            result = activities.stream().filter(a -> a.getTitle().contains(search)).map(activityMapper::toDTO).toList();

        }
        return result;
    }
}
