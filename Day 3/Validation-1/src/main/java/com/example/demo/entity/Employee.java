package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {
	@Id
	private int id;
	
	@NotNull(message="Name should be not empty")
	@Pattern(regexp="^[a-zA-Z]*$",message="Name must contain only letters")
	private String name;
	
	@Min(value=16,message="Age should be greater than or equal to 16")
	@Max(value=60,message="Age should be less than or equal to 60")
	private int age;
	private int salary;
	private String design;
	
	public Employee() {}
	
	public Employee(int id, String name, int age, int salary, String design) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.design = design;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	
	
}
