package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.pojo.Gril;

@RestController
@RequestMapping("/hi")
public class HelloController {
	
	//使用自定义的参数
	@Value("${girl.cupSize}")
	private String cupSize;
	@Value("${girl.height}")
	private int height;
	
	//属性嵌套调用
	@Value("${animal}")
	private String animal;
	
	//使用配置类
	@Autowired
	private Gril girl;
	
	@RequestMapping("/girl")
	public String one(){	
		return cupSize +"--"+height;
	}
	
	@RequestMapping("/girl2")
	public String girl(){	
		return girl.getCupSize() + girl.getHeight();
	}
	
	@RequestMapping("/animal")
	public String two(){	
		return animal;
	}

	
}
