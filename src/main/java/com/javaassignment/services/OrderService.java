package com.javaassignment.services;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.javaassignment.repository.CustomOrderRepository;
import com.javaassignment.repository.Order1Repository;
import com.javaassignment.repository.Order2Repository;
import com.javaassignment.response.CombinedOrderDTO;
import com.javaassignment.response.SpResponse;

@Service
public class OrderService {
	@Autowired
	private Order1Repository order1Repository;

	@Autowired
	CustomOrderRepository combinedOrderRepository;

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

	public Page<Map<String, Object>> getCombinedOrders(int page, int size, String startDate, String endDate,
			String sortBy, String sortOrder) {
		Sort.Direction direction = Sort.Direction.fromString(sortOrder);
		Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
		return combinedOrderRepository.findCombinedOrders(startDate, endDate, pageable);
	}
}
