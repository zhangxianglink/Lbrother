package com.example.demo.annotation.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//IDENTITY属性mysql支持
	private Integer id;
	
	private String name;
	
	
	private Integer height;

	public Boy() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	

}
