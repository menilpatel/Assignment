package com.javaassignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	Page<Products> findByIsDeletedFalseOrderByCreatedAtDesc(Pageable pageable);

	Page<Products> findBycategoryContainingIgnoreCaseAndIsDeletedFalseOrderByCreatedAtDesc(String category,
			Pageable pageable);
}
