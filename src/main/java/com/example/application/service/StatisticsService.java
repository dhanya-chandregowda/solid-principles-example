package com.example.application.service;

import com.example.application.dto.SupplierDto;

import java.util.List;

public interface StatisticsService {

    /**
     * Get supplier statistics with rating greater than or equal to the given rating
     * @param rating
     * @return
     */
    List<SupplierDto> getSupplierStats(Double rating);

}
