package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.MyService;

@Controller
public class controllerLog {
	@Autowired
	private MyService service;
	@GetMapping("/login")
	public String showLoginPage()
	{
		return service.showLoginPage();
	}
	@PostMapping("/login")
	public String handelLogin( @RequestParam String username,@RequestParam String password,Model model)
	{
		return service.handelLogin(username, password, model);
	}
}
