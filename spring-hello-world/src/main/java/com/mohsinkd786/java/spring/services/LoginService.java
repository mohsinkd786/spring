package com.mohsinkd786.java.spring.services;

public class LoginService {

	public LoginService() {

	}

	public boolean login(String user, String pass) {
		if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123"))
			return true;
		else
			return false;
	}
}
