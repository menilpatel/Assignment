package com.javaassignment.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaassignment.entity.Order1;
import com.javaassignment.entity.Order2;
import com.javaassignment.repository.Order1Repository;
import com.javaassignment.repository.Order2Repository;

@Service
public class OrderService {
	@Autowired
	private Order1Repository order1Repository;

	@Autowired
	private Order2Repository order2Repository;

	public Order1 saveOrder1(Order1 order1) {
		return order1Repository.save(order1);
	}

	public Order2 saveOrder2(Order2 order2) {
		return order2Repository.save(order2);
	}

	public Page<Object> getCombinedOrders(Date startDate, Date endDate, String sortBy, String sortOrder,
			Pageable pageable) {
		List<Order1> order1List = order1Repository.findAllByCreatedAtBetween(startDate, endDate);
		List<Order2> order2List = order2Repository.findAllByCreatedAtBetween(startDate, endDate);

		List<Object> combinedOrders = new ArrayList<>();
		combinedOrders.addAll(order1List);
		combinedOrders.addAll(order2List);

		combinedOrders.sort((o1, o2) -> {
			Comparable value1;
			Comparable value2;
			if (sortBy.equals("amount")) {
				value1 = (o1 instanceof Order1) ? ((Order1) o1).getAmount() : ((Order2) o1).getAmount();
				value2 = (o2 instanceof Order1) ? ((Order1) o2).getAmount() : ((Order2) o2).getAmount();
			} else {
				value1 = (o1 instanceof Order1) ? ((Order1) o1).getCreatedAt() : ((Order2) o1).getCreatedAt();
				value2 = (o2 instanceof Order1) ? ((Order1) o2).getCreatedAt() : ((Order2) o2).getCreatedAt();
			}
			return sortOrder.equalsIgnoreCase("ASC") ? value1.compareTo(value2) : value2.compareTo(value1);
		});

		int start = Math.min((int) pageable.getOffset(), combinedOrders.size());
		int end = Math.min((start + pageable.getPageSize()), combinedOrders.size());
		List<Object> output = combinedOrders.subList(start, end);

		return new PageImpl<>(output, pageable, combinedOrders.size());
	}
}
