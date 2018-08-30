package com.example.demo.annotation.pojo;

public class Result<T> {
	
	/**状态码*/
	private Integer status;
	/**提示信息*/
	private String message;
	/**返回信息*/
	private T args;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getArgs() {
		return args;
	}

	public void setArgs(T args) {
		this.args = args;
	}
	
	

}
