package com.mohsinkd786.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mohsinkd786.java.spring.services.CalculatorService;
import com.mohsinkd786.java.spring.services.HomeService;
import com.mohsinkd786.java.spring.services.LoginService;
import com.mohsinkd786.java.spring.services.Operation;
import com.mohsinkd786.java.spring.services.OperationImpl;
import com.mohsinkd786.java.spring.services.ValidatorService;

@Configuration
public class ServiceConfiguration {

	@Bean
	public ValidatorService validator() {
		return new ValidatorService();
	}

	@Bean
	public CalculatorService calculatorService() {
		return new CalculatorService();
	}

	@Bean
	public HomeService homeService() {
		return new HomeService();
	}

	@Bean
	public LoginService loginService() {
		return new LoginService();
	}

	@Bean
	public Operation operate() {
		return new OperationImpl();
	}
}
