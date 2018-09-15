package com.mohsinkd786.java.spring.services;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class HomeService {

	public String message() {
		return "Home Service Message";
	}
}
