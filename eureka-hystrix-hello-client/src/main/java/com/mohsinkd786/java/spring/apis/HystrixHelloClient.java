package com.mohsinkd786.java.spring.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.services.HystrixHelloConsumerService;

@RestController
@RequestMapping("/hystrix")
public class HystrixHelloClient {

	@Autowired
	private HystrixHelloConsumerService service;

	@RequestMapping("/message")
	public String message() {
		return "Hystrix Consumer";
	}

	@RequestMapping("/hello/message")
	public String helloMessage() {
		return service.message();
	}
}
