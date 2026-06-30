package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MyRepo.Repo;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFound;

@Service
public class EmpService {
	@Autowired
	private Repo reposatory;
	
	public List<Employee> getAllEmp()
	{
		return reposatory.findAll();
	}
	
	public Employee getById(int id)
	{
		return reposatory.findById(id).orElseThrow(()->new EmployeeNotFound("Employee Not Found"));
	}
	public String addEmp(Employee emp)
	{
		reposatory.save(emp);
		return "Success";
	}
	public String updateEmp(int id,Employee emp)
	{
		Employee empl=reposatory.getReferenceById(id);
		empl.setAge(emp.getAge());
		empl.setDesign(emp.getDesign());
		empl.setName(emp.getName());
		empl.setSalary(emp.getSalary());
		reposatory.save(empl);
		return "Success";
	}
	public String deleteEmp(int id)
	{
		if(reposatory.existsById(id)) {
			reposatory.deleteById(id);
			return "Success";
		}
		throw new EmployeeNotFound("Employee Not Found");
	}
	public String deleteAll()
	{
		reposatory.deleteAll();
		return"Success";
	}
}
