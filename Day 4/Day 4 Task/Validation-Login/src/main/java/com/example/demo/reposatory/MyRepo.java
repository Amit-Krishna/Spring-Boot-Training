package com.example.demo.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.login;

public interface MyRepo extends JpaRepository<login, String> {

}
