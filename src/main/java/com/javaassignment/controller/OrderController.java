package com.javaassignment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaassignment.entity.Order1;
import com.javaassignment.entity.Order2;
import com.javaassignment.response.CombinedOrder;
import com.javaassignment.response.CombinedOrderDTO;
import com.javaassignment.response.ListDataResponse;
import com.javaassignment.response.ObjectResponse;
import com.javaassignment.response.SpResponse;
import com.javaassignment.services.OrderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/addorder1")
	public ResponseEntity<ObjectResponse> addOrder1(@RequestBody Order1 order) {
		try {
			return new ResponseEntity<ObjectResponse>(
					new ObjectResponse(200, true, "Order1 added succesfully", orderService.saveOrder1(order)),
					HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err addOrder1 : " + ex.getMessage());
			return new ResponseEntity<ObjectResponse>(new ObjectResponse(500, false, "Something went wrong!", null),
					HttpStatus.OK);
		}
	}

	@PostMapping("/addorder2")
	public ResponseEntity<ObjectResponse> addOrder2(@RequestBody Order2 order) {
		try {
			return new ResponseEntity<ObjectResponse>(
					new ObjectResponse(200, true, "Order2 added succesfully", orderService.saveOrder2(order)),
					HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err addOrder1 : " + ex.getMessage());
			return new ResponseEntity<ObjectResponse>(new ObjectResponse(500, false, "Something went wrong!", null),
					HttpStatus.OK);
		}
	}

	@GetMapping("/getallorders")
	public ResponseEntity<?> getAllOrders(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("sortby") String sortby, @RequestParam("sortorder") String sortOrder) {
		try {
			SpResponse orders = orderService.getAllOrders(page, size, startDate, endDate, sortby, sortOrder);
			return new ResponseEntity<>(new ListDataResponse(200, true, "List of orders", orders.getRecordCount(),
					orders.getTotalPageCount(), orders.getlist()), HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err getAllOrders : " + ex.getMessage());
			return new ResponseEntity<>(new ListDataResponse(500, false, "Something went wrong!", 0, 0, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
