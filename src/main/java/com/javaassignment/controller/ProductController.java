package com.javaassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaassignment.entity.Products;
import com.javaassignment.response.ListDataResponse;
import com.javaassignment.response.ObjectResponse;
import com.javaassignment.response.SpResponse;
import com.javaassignment.services.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/addproduct")
	public ResponseEntity<ObjectResponse> addProduct(@RequestBody Products products) {
		try {
			return new ResponseEntity<ObjectResponse>(
					new ObjectResponse(200, true, "Product added succesfully", productService.saveProduct(products)),
					HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err addProduct : " + ex.getMessage());
			return new ResponseEntity<ObjectResponse>(new ObjectResponse(500, false, "Something went wrong!", null),
					HttpStatus.OK);
		}
	}

	@GetMapping("/getallproducts")
	public ResponseEntity<ListDataResponse> getAllProducts(@RequestParam("pageindex") int pageindex,
			@RequestParam("pagesize") int pagesize,
			@RequestParam(name = "sortparam", required = false) String sortparam,
			@RequestParam("searchdata") String searchdata) {
		try {
			SpResponse list = productService.getAllProducts(pageindex, pagesize, searchdata);
			return new ResponseEntity<>(new ListDataResponse(200, true, "List of products", list.getRecordCount(),
					list.getTotalPageCount(), list.getlist()), HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err getAllProducts : " + ex.getMessage());
			return new ResponseEntity<>(new ListDataResponse(500, false, "Something went wrong!", 0, 0, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
