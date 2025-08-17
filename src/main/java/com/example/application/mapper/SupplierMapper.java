package com.example.application.mapper;

import com.example.application.dto.SupplierDto;
import com.example.application.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public SupplierDto toDTO(Supplier supplier){
        return SupplierDto.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .country(supplier.getCountry())
                .build();
    }
}
