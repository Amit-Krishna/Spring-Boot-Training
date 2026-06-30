package com.example.demo.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface MyRepo extends JpaRepository<User, Integer>{

}
