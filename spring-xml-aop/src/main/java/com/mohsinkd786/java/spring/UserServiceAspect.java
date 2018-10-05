package com.mohsinkd786.java.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserServiceAspect {

	@Before("execution(* com.mohsinkd786.java.spring.UserService.getMessage())")
	public void getMessageAdvice() {
		System.out.println("Executing Advice on getMessage()");
	}
}
