package com.mohsinkd786.java.spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(path = "/message", method = RequestMethod.GET)
	public String message() {
		return "Eureka Hello Service - 8111";
	}
}
