package com.example.application.controller;

import com.example.application.dto.SupplierDto;
import com.example.application.service.StatisticsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stats")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping("/suppliers/{rating}")
    public List<SupplierDto> supplierStats(@PathVariable Double rating) {
        return statisticsService.getSupplierStats(rating);
    }
}
