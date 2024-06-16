package com.javaassignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaassignment.entity.Products;

public interface ProductRepository extends CrudRepository<Products, Integer> {

}
