package com.example.demo.utils;

import com.example.demo.annotation.pojo.Result;

import exception.ExceptionEnums;

public class ResultUtils {
	
	/** 
	 *  带参数的成功方法
	 */
	public static Result<Object> success( ExceptionEnums enums,Object object){
		Result<Object> result = new Result<>();
		result.setStatus(enums.getCode());
		result.setMessage(enums.getMsg());
		result.setArgs(object);
		return result;
	}
	
	/**
	 * 不带参数的成功方法
	 */
	public static Result<Object> success(ExceptionEnums enums){
		Result<Object> success = ResultUtils.success(enums,null);
		return success;
	}
	
	/**
	 * 失败方法
	 */
	public static Result<Object> error(Integer status, String msg){
		Result<Object> result = new Result<>();
		result.setStatus(status);
		result.setMessage(msg);
		return result;
	}

}
