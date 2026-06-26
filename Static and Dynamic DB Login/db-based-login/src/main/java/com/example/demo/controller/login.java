
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.entity;
import com.example.demo.reposatory.repo;

@Controller
public class login {
	@Autowired
	public repo reposatory;
	
	@PostMapping("/add")
	public String add(@RequestBody entity e)
	{
		reposatory.save(e);
		return "login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login"; // login.html
		
	}
	
	// 2. Handle Login here
	@PostMapping("/login")
	public String handleLogin(
			@RequestParam String username,
			@RequestParam String password,
			Model model) {
//		
//		List<entity> li=reposatory.findAll();
//		for(entity i:li)
//		{
//			if(i.getUsername().equals(username)&&i.getPassword().equals(password))
//			{
//				model.addAttribute("username",i.getUsername());
//				return "welcome";
//			}
//		}
//		model.addAttribute("error","user not found or wrong password");
//		return "login";
		entity e=reposatory.getReferenceById(username);
		if(e.getPassword().equals(password))
		{
			model.addAttribute("username",e.getUsername());
			return "welcome";
		}
		model.addAttribute("error","user not found or wrong password");
		return "login";
		
	}
}
