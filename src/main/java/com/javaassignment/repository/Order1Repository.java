package com.javaassignment.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.entity.Order1;

public interface Order1Repository extends JpaRepository<Order1, Integer> {
	List<Order1> findAllByCreatedAtBetween(Date startDate, Date endDate);

	Page<Order1> findAllByCreatedAtBetween(Date startDate, Date endDate, Pageable pageable);
}
