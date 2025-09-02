package com.practice.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.thymeleaf.entity.Product;
import com.practice.thymeleaf.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;

	@Override
	public Product saveProduct(Product p) {
		return repo.save(p);
	}

	@Override
	public List<Product> allProducts() {
		return repo.findAll();
	}

	@Override
	public void deleteProduct(Integer id) {
	
		repo.deleteById(id);
		
	}

	@Override
	public Product getProduct(Integer id) {
		
		return repo.findById(id).orElseThrow(null);
	}	
	
}
