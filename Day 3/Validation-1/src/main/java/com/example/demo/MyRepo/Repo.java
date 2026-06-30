package com.example.demo.MyRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface Repo extends JpaRepository<Employee, Integer> {

}
