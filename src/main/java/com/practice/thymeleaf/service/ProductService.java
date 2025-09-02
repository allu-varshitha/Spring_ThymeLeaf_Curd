package com.practice.thymeleaf.service;

import java.util.List;

import com.practice.thymeleaf.entity.Product;

public interface ProductService {

	Product saveProduct(Product p);
	
	List<Product> allProducts();
	
	void deleteProduct(Integer id);
	
	Product getProduct(Integer id);
	
}
