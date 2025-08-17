package com.example.application.controller;

import com.example.application.dto.SupplierDto;
import com.example.application.service.SupplierService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierDto>> suppliers() {
        return ResponseEntity.ok(supplierService.listAllSuppliers());
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<SupplierDto>> suppliersSearch(@PathVariable String search) {
        return ResponseEntity.ok(supplierService.searchSuppliers(search));
    }
}
