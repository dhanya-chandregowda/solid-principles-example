package com.example.application.controller;

import com.example.application.dto.ActivityDto;
import com.example.application.service.ActivityService;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/activities")
public class ActivitiesController {

    private final ActivityService activityService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ActivityDto>> activities() {
        return ResponseEntity.ok(activityService.listAllActivities());
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<ActivityDto> activities( @PathVariable Long id ){
        return ResponseEntity.ok(activityService.getActivityById(id));
    }

    @GetMapping("/search/{search}")
    //look for patter match
    public ResponseEntity<List<ActivityDto>> activitiesSearch(@PathVariable String search) {
        return ResponseEntity.ok(activityService.searchActivities(search));
    }
}
