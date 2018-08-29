package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.pojo.Boy;
import com.example.demo.repository.BoyRepository;



@RestController
@RequestMapping("/boy")
//简单CRUD
public class BoyController {
	
	@Autowired
	private BoyRepository repository;
	
	@RequestMapping("/list")
	public List<Boy> getList(){
		return repository.findAll();
	}
	
	@RequestMapping("save")
	public Boy save(@RequestParam("name") String name,
			       @RequestParam("height") Integer height){
		Boy boy = new Boy();
		boy.setName(name);
		boy.setHeight(height);
		return repository.save(boy);
	}

	@RequestMapping("/get/{id}")
	public Optional<Boy> getOne(@PathVariable("id") Integer id){
		Optional<Boy> boy = repository.findById(id);
        return boy;
	}
	
	@RequestMapping("/del/{id}")
	public void delOne(@PathVariable("id") Integer id){
		repository.deleteById(id);
	}
	
	@RequestMapping("/update/{id}")
	public Boy updateOne(@RequestParam("id") Integer id,
			@RequestParam("name") String name,
		       @RequestParam("height") Integer height){
		Boy boy = new Boy();
		boy.setHeight(height);
		boy.setName(name);
		boy.setId(id);
		return repository.save(boy);
	}
	
	@GetMapping("/get/name/{name}")
	public List<Boy> getByName(@PathVariable("name") String name){
		return repository.findByName(name);
	}
}
