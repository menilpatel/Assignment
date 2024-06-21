package com.javaassignment.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.javaassignment.entity.Order1;
import com.javaassignment.response.CombinedOrder;
import com.javaassignment.response.CombinedOrderDTO;

public interface CombinedOrderRepository extends PagingAndSortingRepository<Order1, Integer> {

	@Query(value = "SELECT id, product_id AS productId, amount, is_deleted AS isDeleted, created_at AS createdAt, updated_at AS updatedAt "
			+ "FROM (" + " SELECT id, product_id, amount, is_deleted, created_at, updated_at FROM Order1 "
			+ "    UNION ALL " + " SELECT id, product_id, amount, is_deleted, created_at, updated_at FROM Order2"
			+ ") combined_orders " + "ORDER BY :sortBy", countQuery = "SELECT COUNT(*) FROM ("
					+ " SELECT id FROM Order1 " + "    UNION ALL " + " SELECT id FROM Order2" + ") combined_orders "
					+ "", nativeQuery = true)
	Page<CombinedOrder> findCombinedOrders(@Param("sortBy") String sortBy, Pageable pageable);
}