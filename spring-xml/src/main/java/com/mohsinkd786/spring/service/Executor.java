package com.mohsinkd786.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executor {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");
		HelloService serviceObj1 = (HelloService) context.getBean("hello");
		HelloService serviceObj2 = (HelloService) context.getBean("hello");

		HelloService service1Obj1 = (HelloService) context.getBean("hello1");

		HelloService service2Obj1 = (HelloService) context.getBean("helloService");

		System.out.println(serviceObj1.getText());
		System.out.println(serviceObj2.getText());

		System.out.println(service1Obj1.getText());

		System.out.println(service2Obj1.getText() + " " + service2Obj1.getIndex());
		// MessageService

		MessageService mService1 = (MessageService) context.getBean("mService1");
		MessageService mService2 = (MessageService) context.getBean("mService2");
		mService1.execute();
		mService2.execute();

		// UserService
		UserService uService = context.getBean(UserService.class);
		System.out.println(uService.getMessage());
		System.out.println(uService.execute(10, 2));
	}
}
