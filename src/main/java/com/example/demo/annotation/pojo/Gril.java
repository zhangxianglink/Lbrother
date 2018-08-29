package com.example.demo.annotation.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="girl")
public class Gril {
	
	private String cupSize;
	private int height;
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Gril [cupSize=" + cupSize + ", height=" + height + "]";
	}	
}
