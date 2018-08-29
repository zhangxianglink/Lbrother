package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.pojo.Gril;

//@Controller
@RestController
@RequestMapping("/a")
public class AController {
	
	@RequestMapping(value="/thy",method= RequestMethod.GET)
	public String thy(){
		return "a";
	}
	
	@GetMapping(value="/get/{id}")
	public String get1(@PathVariable("id") Integer id){
		return "注解中id要和参数名一致:"+id;
	}
	
	@GetMapping("/get2")
	public String get2(@RequestParam("id") Integer myId){
		return "myId:"+myId;
	}
	
	@PostMapping("/post")
	public String post(Gril girl){
		return girl.toString();
	}

}
