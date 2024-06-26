package com.javaassignment.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	@GetMapping("/getallorders1")
	public ResponseEntity<?> getAllOrders1(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("sortby") String sortby, @RequestParam("sortorder") String sortOrder) {
		try {
			Page<Map<String, Object>> orders = orderService.getCombinedOrders(page, size, startDate, endDate, sortby,
					sortOrder);
			List<CombinedOrderDTO> listorder = orders.getContent().stream().map(this::convertToCombinedOrder)
					.collect(Collectors.toList());
			return new ResponseEntity<>(new ListDataResponse(200, true, "List of orders",
					(int) orders.getTotalElements(), orders.getTotalPages(), listorder), HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err getAllOrders : " + ex.getMessage());
			return new ResponseEntity<>(new ListDataResponse(500, false, "Something went wrong!", 0, 0, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private CombinedOrderDTO convertToCombinedOrder(Map<String, Object> map) {
		CombinedOrderDTO order = new CombinedOrderDTO();
		order.setId((int) map.get("id"));
		order.setAmount((double) map.get("amount"));
		order.setProductId((int) map.get("product_id"));
		order.setIsDeleted((Boolean) map.get("is_deleted"));
		order.setCreatedAt((Date) map.get("created_at"));
		order.setUpdatedAt((Date) map.get("updated_at"));
		return order;
	}

}
