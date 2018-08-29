package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.annotation.pojo.Boy;

public interface BoyRepository extends JpaRepository<Boy, Integer>{

	//拓展,
	public List<Boy> findByName(String name);
}
