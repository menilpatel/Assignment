package com.javaassignment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.entity.Order1;

public interface Order1Repository extends JpaRepository<Order1, Integer> {
	List<Order1> findAllByCreatedAtBetween(Date startDate, Date endDate);
}
