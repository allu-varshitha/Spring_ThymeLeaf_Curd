package com.practice.thymeleaf.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.thymeleaf.entity.Admin;
import com.practice.thymeleaf.repository.AdminRepository;

@Component
public class Data implements CommandLineRunner {

	@Value("${admin.user.name}")
	
	String name;
	
	@Value("${admin.user.pass}")
	String pass;
	
	@Autowired
	AdminRepository ar;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Admin a=new Admin();
		a.setName(name);
		a.setPass(pass);
		
		ar.save(a);
		
	}

}
