package com.javaassignment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.entity.Order2;

public interface Order2Repository extends JpaRepository<Order2, Integer> {
	List<Order2> findAllByCreatedAtBetween(Date startDate, Date endDate);

	List<Order2> findAllByCreatedAtBetweenOrderByAmountDesc(Date startDate, Date endDate);
}
