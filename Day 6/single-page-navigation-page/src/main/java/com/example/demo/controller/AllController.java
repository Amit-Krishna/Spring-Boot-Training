package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {
	@GetMapping("/contact")
	public String contactController(Model model) {
		model.addAttribute("title", "Contact");
		model.addAttribute("message", "Contact us for more information");
		return "dashboard";
	}

	@GetMapping("/about")
	public String aboutController(Model model) {
		model.addAttribute("title", "About");
		model.addAttribute("message", "Know more about us by clicking HERE");
		return "dashboard";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home");
		model.addAttribute("message", "Welcome to the School Portal");
		return "dashboard";
	}

	@GetMapping("/student")
	public String studentController(Model model) {
		model.addAttribute("title", "Student");
		model.addAttribute("name", "Amit");
		model.addAttribute("course", "B-Tech");
		model.addAttribute("semester", "7");
		model.addAttribute("college", "LPU");
		return "dashboard";
	}
}
