package com.example.demo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Aspect //切面
@Component //将类注入spring容器
public class BoyAspect {
	
	private static final Logger logger = Logger.getLogger(BoyAspect.class);
	
	@Pointcut(value="execution(public * com.example.demo.controller..*.*(..))")
	public void log(){
		
	}
	
   
	@Before("log()")
	public void doBefore(JoinPoint joinpot){ 
		putLog(joinpot);
	}
	
	@AfterReturning(pointcut="log()",returning="object")
	public void doAfterReturning(Object object){
		logger.infof("response={}",object.toString());
	}

	private static void putLog(JoinPoint joinpot){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("Url:         "+request.getRequestURI());
		logger.info("Method:      "+request.getMethod());
		logger.info("Addr:        "+request.getRemoteAddr());
		logger.info("Class_Method:"+joinpot.getSignature().getDeclaringTypeName()+"."+joinpot.getSignature().getName());
		logger.info("arg:         "+joinpot.getArgs());
	}
	
	
}
