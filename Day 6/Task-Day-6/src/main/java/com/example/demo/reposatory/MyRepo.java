package com.example.demo.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;



public interface MyRepo extends JpaRepository<UserEntity, Integer>{

}
