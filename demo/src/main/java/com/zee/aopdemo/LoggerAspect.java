package com.zee.aopdemo;



import javax.sql.rowset.Joinable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {
	
	private Logger logger=  LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.zee.aopdemo.*.*(..))")
	public void before(JoinPoint joinPoint) {
		
		 logger.error(" Check for user access ");
	        logger.error(" Allowed execution for {}", joinPoint);
	}
	
	@After("execution(* com.zee.aopdemo.*.*(..))")
public void after(JoinPoint joinPoint) {
		logger.info("after execution of{}",joinPoint);
	}
	@AfterReturning(value="execution(* com.zee.aopdemo.service.*.*(..))",returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result ) {
			logger.info("{} returned{}",joinPoint, result);
		}
	
}
