package com.practice.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.thymeleaf.entity.Admin;
import com.practice.thymeleaf.repository.AdminRepository;

@Controller
public class AdminController {

	@Autowired
	AdminRepository ar;
	
	@GetMapping("/app")
	public String validPage(Model model){
		return "validation";
		
	}
	
	@PostMapping("/login")
	public String validate(@ModelAttribute Admin admin,Model model) {
		Admin a=ar.findById(1).orElse(null);
		if(admin.getName().equals(a.getName())) {
			if(admin.getPass().equals(a.getPass())) {
				return "redirect:/all";
			}
		}
		model.addAttribute("message","invalid user and pass");
		return "validation";
	}
}
