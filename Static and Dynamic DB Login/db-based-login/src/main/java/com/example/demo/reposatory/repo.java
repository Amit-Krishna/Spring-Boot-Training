package com.example.demo.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.entity;

public interface repo extends JpaRepository<entity, String> {
	//public optional<String> getByUsername(); 
}
