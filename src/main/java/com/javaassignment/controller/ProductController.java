package com.javaassignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	// Changes required:
	// As per the task the system should handle the 400 and 500 both type of errors.
	// Not able to run the application so attach the images of both tasks.


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
	public ResponseEntity<?> getAllProducts(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("searchdata") String searchdata) {
		try {
			Pageable pageable = PageRequest.of(page, size);
			Page<Products> products = productService.getProducts(searchdata, pageable);
			return new ResponseEntity<>(new ListDataResponse(200, true, "List of products",
					(int) products.getTotalElements(), products.getTotalPages(), products.getContent()), HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("err getAllProducts : " + ex.getMessage());
			return new ResponseEntity<>(new ListDataResponse(500, false, "Something went wrong!",0,0, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
