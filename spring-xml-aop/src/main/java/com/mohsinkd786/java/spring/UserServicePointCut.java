package com.mohsinkd786.java.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserServicePointCut {

	@Pointcut("within(com.mohsinkd786.java.spring.*)")
	public void getMessagePoint() {
		System.out.println("Point Cut Method ");
	}
}
