package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.except.EmployeeNotFound;
import com.example.demo.repo.MyRepo;

@RestController
public class MyController {
	
	@Autowired
	public MyRepo repository;
	
	//ADD
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody Employee emp)
	{
		repository.save(emp);
		return "Emp Added Success";
	}
	
	//get all
	@GetMapping("/getAll")
	public List<Employee> getEmp()
	{
		return repository.findAll();
	}
	
	//get by id
	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable int id)
	{
		Optional<Employee> emp=repository.findById(id);
		return emp.orElseThrow(()->new EmployeeNotFound("Employee not found"));
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id)
	{
		if(repository.existsById(id))
		{
			repository.deleteById(id);
			return "deleteion successful";
		}
		throw new EmployeeNotFound("Employee not found");
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll()
	{
		repository.deleteAll();
		return "Deleted all";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id, @RequestBody Employee emp)
	{
		
		if(repository.existsById(id))
		{
			Employee empl=repository.getReferenceById(id);
			empl.setName(emp.getName());
			empl.setSalary(emp.getSalary());
			repository.save(empl);
			return "Updated";
		}
		throw new EmployeeNotFound("Employee not found");
	}
}
