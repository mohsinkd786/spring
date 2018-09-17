package com.mohsinkd786.java.spring.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping("/login")
	public boolean login() {
		return true;
	}

	@RequestMapping("/message")
	public String message() {
		return "Hello Logged In successfully";
	}
}
