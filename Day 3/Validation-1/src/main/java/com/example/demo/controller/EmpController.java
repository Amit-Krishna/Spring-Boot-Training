package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmpService;
import com.example.demo.entity.Employee;


import jakarta.validation.Valid;

@RestController
public class EmpController {
	@Autowired
	private EmpService service;
	
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody Employee emp)
	{
		return service.addEmp(emp);
		
	}
	
	@GetMapping("/getById")
	public Employee getById(@Valid @PathVariable int id)
	{
		return service.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmp()
	{
		return service.getAllEmp();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee emp,@Valid @PathVariable int id)
	{
		service.updateEmp(id, emp);
		return "Successfull";
	}

}
