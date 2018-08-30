package com.example.demo.handler;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.annotation.pojo.Result;

import com.example.demo.utils.ResultUtils;

import exception.BoyException;

@ControllerAdvice
public class ExceptionHandle {
	
	private static final Logger logger = Logger.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<Object> handle(Exception e) {
		if (e instanceof BoyException) {
			BoyException boyException = (BoyException) e;
			return ResultUtils.error(boyException.getStatus(), boyException.getMessage());
		} else {
			logger.error("未知错误::::"+e);
			return ResultUtils.error(-1, "未收录错误");
		}
	}
}
