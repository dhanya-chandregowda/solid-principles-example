package com.example.application.repository;

import com.example.application.dto.SupplierDto;
import com.example.application.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier,Long> {

    String SUPPLIER_QUERY= """
            Select s* from test.supplier s where s.name like :search or s.country like :search
            """;
    @Query(value=SUPPLIER_QUERY, nativeQuery = true)
    List<Supplier> searchSuppliers(@Param("search") String search);

}
