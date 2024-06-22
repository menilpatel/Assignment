package com.javaassignment.repository;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.javaassignment.entity.Order1;

public interface CustomOrderRepository extends PagingAndSortingRepository<Order1, Integer> {
	@Query(value = "SELECT DISTINCT id, product_id, amount, is_deleted, created_at, updated_at "
            + "FROM ("
            + " SELECT DISTINCT id, product_id, amount, is_deleted, created_at, updated_at FROM Order1 "
            + " WHERE created_at BETWEEN :startDate AND :endDate "
            + " UNION ALL "
            + " SELECT DISTINCT id, product_id, amount, is_deleted, created_at, updated_at FROM Order2 "
            + " WHERE created_at BETWEEN :startDate AND :endDate"
            + ") combined_orders",
            countQuery = "SELECT COUNT(*) FROM ("
            + " SELECT id FROM Order1 "
            + " WHERE created_at BETWEEN :startDate AND :endDate "
            + " UNION ALL "
            + " SELECT id FROM Order2 "
            + " WHERE created_at BETWEEN :startDate AND :endDate"
            + ") combined_orders",
            nativeQuery = true)
	Page<Map<String, Object>> findCombinedOrders(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);

}