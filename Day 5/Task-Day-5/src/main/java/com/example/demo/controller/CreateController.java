package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.services.MyServices;

@Controller
public class CreateController {
	@Autowired
	private MyServices services;
	
	@PostMapping("/addUser")
	public String addUser(User user)
	{
		boolean flag = services.addUser(user);

	    if(flag)
	        return "addUser";

	    return "Main";
	}
	
	@GetMapping("/getUsers")
	public String getUsers(Model model)
	{
		model.addAttribute("users", services.getUsers());
		return "users";
	}
	
	@PostMapping("/raiseSalary")
	public String raiseSalary(@RequestParam int id,Model model)
	{
		if (!services.handleSalaryRaise(id)) {
	        model.addAttribute("error", "User not found");
	    }
		else model.addAttribute("success", "Salary Updated");

	    return "Main";
	}
	@GetMapping("/Main")
	public String showMainPage() {
		return "Main"; 
		
	}
	@GetMapping("/addUser")
	public String addUserPage() {
	    return "addUser";
	}
	
	@GetMapping("/raiseSalary")
	public String raiseSalaryPage() {
	    return "raiseSalary";
	}
	@GetMapping("/exit")
	public String exit() {
	    return "Main";   
	}
}
