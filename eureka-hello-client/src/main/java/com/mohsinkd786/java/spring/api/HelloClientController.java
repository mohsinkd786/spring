package com.mohsinkd786.java.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloClientController {

	@Autowired
	private HelloConsumerService service;

	@GetMapping("/hello/message")
	public String message() {
		return service.getMessage();
	}
}
