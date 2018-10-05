package com.mohsinkd786.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executor {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-conf.xml");
		UserService service = ctx.getBean(UserService.class);
		service.getMessage();
	}
}
