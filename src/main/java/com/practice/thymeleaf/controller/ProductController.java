package com.practice.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.thymeleaf.entity.Product;
import com.practice.thymeleaf.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@GetMapping("/")
	public String form() {
		return "AddProduct";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product p) {
		ps.saveProduct(p);
		return "redirect:/all";
		
	}
	
	@GetMapping("/all")
	public String allProducts(Model model) {
	    model.addAttribute("products",ps.allProducts());
		return "ListProducts";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteproduct(@PathVariable Integer id) {
		ps.deleteProduct(id);
		return "redirect:/all";
	}
	
	@GetMapping("/edit/{id}")
	public String getProduct(@PathVariable Integer id,Model model) {
	model.addAttribute("data",ps.getProduct(id));
		return "Editproducts";
	}

}
