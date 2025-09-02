package com.practice.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.thymeleaf.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
