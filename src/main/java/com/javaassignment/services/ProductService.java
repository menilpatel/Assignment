package com.javaassignment.services;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.javaassignment.entity.Products;
import com.javaassignment.repository.ProductRepository;
import com.javaassignment.response.SpResponse;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Products saveProduct(Products product) {
		return productRepository.save(product);
	}

	public SpResponse getAllProducts(int pageindex, int pagesize, String searchdata) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SPGetAllProducts")
				.declareParameters(new SqlParameter("PageIndex", Types.INTEGER),
						new SqlParameter("PageSize", Types.INTEGER), new SqlParameter("SearchData", Types.VARCHAR),
						new SqlOutParameter("RecordCount", Types.INTEGER),
						new SqlOutParameter("TotalPageCount", Types.INTEGER))
				.returningResultSet("result-set-1", BeanPropertyRowMapper.newInstance(Products.class));
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("PageIndex", pageindex);
		inParams.put("PageSize", pagesize);
		inParams.put("SearchData", searchdata);

		Map<String, Object> result = jdbcCall.execute(inParams);
		List<Products> resultList = (List<Products>) result.get("result-set-1");

		Integer RecordCount = (Integer) result.get("RecordCount");
		Integer TotalPageCount = (Integer) result.get("TotalPageCount");

		SpResponse response = new SpResponse();
		response.setRecordCount(RecordCount);
		response.setTotalPageCount(TotalPageCount);
		response.setlist(resultList);

		return response;

	}

}
