package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.pojo.Boy;
import com.example.demo.annotation.pojo.Result;
import com.example.demo.repository.BoyRepository;
import com.example.demo.service.BoyService;
import com.example.demo.utils.ResultUtils;

import exception.ExceptionEnums;



@RestController
@RequestMapping("/boy")
//简单CRUD
public class BoyController {
	
	@Autowired
	private BoyRepository repository;
	
	@Autowired
	private BoyService boyService;
	
	@RequestMapping("/list")
	public List<Boy> getList(){
		return repository.findAll();
	}
	
	@RequestMapping("save")
	public Boy save(
			@RequestParam("name") String name,
			       @RequestParam("height") Integer height){
		Boy boy = new Boy();
		boy.setName(name);
		boy.setHeight(height);
		return repository.save(boy);
	}
	
	/**
	 * 测试异常处理机制
	 * @param boy
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/save2")
	public Result save2( @Valid  Boy boy, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtils.error(500, bindingResult.getFieldError().getDefaultMessage());
		}
		boy.setId(null);
		return ResultUtils.success(ExceptionEnums.SUCCESS,repository.save(boy));
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
	public Boy updateOne(@PathVariable("id") Integer id,
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
	
	@GetMapping(value="get/height/{id}")
	public void getHeight(@PathVariable("id") Integer id) throws Exception{
		boyService.getHeight(id);
	}
}
