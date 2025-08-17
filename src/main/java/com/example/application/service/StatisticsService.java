package com.example.application.service;

import com.example.application.dto.ActivityDto;
import com.example.application.dto.SupplierDto;
import com.example.application.repository.StatisticsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public List<SupplierDto> getSupplierStats(Double rating) {
        List<SupplierDto> result = new ArrayList<>();
        statisticsRepository.getSupplierStats(rating).forEach(stat-> {
                    result.add(SupplierDto.builder()
                            .name(stat.getName())
                            .id(stat.getId())
                            .address(stat.getAddress())
                            .country(stat.getCountry())
                            .zip(stat.getZip())
                            .build());

        });
        return result;
    }
}
