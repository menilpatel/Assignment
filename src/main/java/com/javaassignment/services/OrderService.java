package com.javaassignment.services;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.javaassignment.entity.Order1;
import com.javaassignment.entity.Order2;
import com.javaassignment.repository.CombinedOrderRepository;
import com.javaassignment.repository.Order1Repository;
import com.javaassignment.repository.Order2Repository;
import com.javaassignment.response.CombinedOrder;
import com.javaassignment.response.CombinedOrderDTO;
import com.javaassignment.response.SpResponse;

@Service
public class OrderService {
	@Autowired
	private Order1Repository order1Repository;

	@Autowired
	CombinedOrderRepository combinedOrderRepository;

	@Autowired
	private Order2Repository order2Repository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Order1 saveOrder1(Order1 order1) {
		return order1Repository.save(order1);
	}

	public Order2 saveOrder2(Order2 order2) {
		return order2Repository.save(order2);
	}

	public SpResponse getAllOrders(int pageindex, int pagesize, String startDate, String endDate, String sortBy,
			String sortOrder) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SPGetAllOrders")
				.declareParameters(new SqlParameter("PageIndex", Types.INTEGER),
						new SqlParameter("PageSize", Types.INTEGER), new SqlParameter("startDate", Types.VARCHAR),
						new SqlParameter("endDate", Types.VARCHAR), new SqlParameter("sortBy", Types.VARCHAR),
						new SqlParameter("sortOrder", Types.VARCHAR), new SqlOutParameter("RecordCount", Types.INTEGER),
						new SqlOutParameter("TotalPageCount", Types.INTEGER))
				.returningResultSet("result-set-1", BeanPropertyRowMapper.newInstance(CombinedOrderDTO.class));
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("PageIndex", pageindex);
		inParams.put("PageSize", pagesize);
		inParams.put("startDate", startDate);
		inParams.put("endDate", endDate);
		inParams.put("sortBy", sortBy);
		inParams.put("sortOrder", sortOrder);

		Map<String, Object> result = jdbcCall.execute(inParams);
		List<CombinedOrderDTO> resultList = (List<CombinedOrderDTO>) result.get("result-set-1");

		Integer RecordCount = (Integer) result.get("RecordCount");
		Integer TotalPageCount = (Integer) result.get("TotalPageCount");

		SpResponse response = new SpResponse();
		response.setRecordCount(RecordCount);
		response.setTotalPageCount(TotalPageCount);
		response.setlist(resultList);

		return response;

	}

	// public Page<CombinedOrder> getCombinedOrders(Date startDate, Date endDate,
	// int page, int size, String sortBy) {
//		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//		return combinedOrderRepository.findCombinedOrders(sortBy, pageable);
	// }

//	public Page<Object> getCombinedOrders(Date startDate, Date endDate, String sortBy, String sortOrder,
//			Pageable pageable) {
//		List<Order1> order1List = order1Repository.findAllByCreatedAtBetween(startDate, endDate);
//		List<Order2> order2List = order2Repository.findAllByCreatedAtBetween(startDate, endDate);
//
//		List<Object> combinedOrders = new ArrayList<>();
//		combinedOrders.addAll(order1List);
//		combinedOrders.addAll(order2List);
//
//		combinedOrders.sort((o1, o2) -> {
//			Comparable value1;
//			Comparable value2;
//			if (sortBy.equals("amount")) {
//				value1 = (o1 instanceof Order1) ? ((Order1) o1).getAmount() : ((Order2) o1).getAmount();
//				value2 = (o2 instanceof Order1) ? ((Order1) o2).getAmount() : ((Order2) o2).getAmount();
//			} else {
//				value1 = (o1 instanceof Order1) ? ((Order1) o1).getCreatedAt() : ((Order2) o1).getCreatedAt();
//				value2 = (o2 instanceof Order1) ? ((Order1) o2).getCreatedAt() : ((Order2) o2).getCreatedAt();
//			}
//			return sortOrder.equalsIgnoreCase("ASC") ? value1.compareTo(value2) : value2.compareTo(value1);
//		});
//
//		int start = Math.min((int) pageable.getOffset(), combinedOrders.size());
//		int end = Math.min((start + pageable.getPageSize()), combinedOrders.size());
//		List<Object> output = combinedOrders.subList(start, end);
//
//		return new PageImpl<>(output, pageable, combinedOrders.size());
//	}
}
