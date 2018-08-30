package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.annotation.pojo.Boy;
import com.example.demo.repository.BoyRepository;
import com.example.demo.service.BoyService;

import exception.BoyException;
import exception.ExceptionEnums;

@Service
public class BoyServiceImpl implements BoyService {
	
	@Autowired
	private BoyRepository repository;

	@Override
	@Transactional
	public void getHeight(Integer id) throws Exception {
		Optional<Boy> boy = repository.findById(id);
		Boy boy2 = boy.get();
		Integer height = boy2.getHeight();
		if(height > 199){
			//为减少繁琐的判断,抛出异常
			throw new BoyException(ExceptionEnums.TOOLONG);
		}else if( height <= 199 && height >= 170){
			throw new BoyException(ExceptionEnums.LONG);
		}else {
			throw new BoyException(ExceptionEnums.SHORT);
		}
		
	}

}
