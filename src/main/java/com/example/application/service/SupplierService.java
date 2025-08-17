package com.example.application.service;

import com.example.application.dto.SupplierDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    /**
     * Lists all the available suppliers
     * @return list of suppliers
     */
    List<SupplierDto> listAllSuppliers();

    /**
     * Search all suppliers matching the input parameter
     * @param search
     * @return
     */
    List<SupplierDto> searchSuppliers(String search);

}
