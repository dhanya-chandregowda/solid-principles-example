package com.example.application.repository;

import com.example.application.dto.SupplierDto;
import com.example.application.entity.Supplier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Supplier, Long> {
    String SUPPLIER_STATS_QUERY = """
        SELECT s.* FROM test.supplier s inner join test.activity a on s.id=a.supplier_id WHERE a.rating > :rating
        """;

    @Query(value = SUPPLIER_STATS_QUERY, nativeQuery = true)
    List<Supplier> getSupplierStats( Double rating);
}
