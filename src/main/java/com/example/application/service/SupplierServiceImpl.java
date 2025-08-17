package com.example.application.service;

import com.example.application.dto.SupplierDto;
import com.example.application.entity.Supplier;
import com.example.application.mapper.SupplierMapper;
import com.example.application.repository.SuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService{

    private final SuppliersRepository suppliersRepository;

    private final SupplierMapper supplierMapper;

    @Override
    public List<SupplierDto> listAllSuppliers() {
        List<Supplier> suppliers= suppliersRepository.findAll();
        List<SupplierDto> supplierList= new ArrayList<>();
        if (!suppliers.isEmpty()) {
            supplierList= suppliers.stream().map(supplierMapper::toDTO).toList();
        }
        return supplierList;
    }

    @Override
    public List<SupplierDto> searchSuppliers(String search) {
        List<Supplier> suppliers = suppliersRepository.findAll();
        List<SupplierDto> searchResult = new ArrayList<>();

        if (!suppliers.isEmpty()) {
            searchResult =suppliers.stream().filter(supplier -> (new StringBuilder()
                            .append(supplier.getName())
                            .append(supplier.getCity())
                            .append(supplier.getCountry())
                            .append(supplier.getAddress())
                            .append(supplier.getZip()).toString().toLowerCase().contains(search.toLowerCase())))
                    .map(supplierMapper::toDTO).toList();
        }
        return searchResult;
    }
}
