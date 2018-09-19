package com.mohsinkd786.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@GetMapping("/status")
	public String status() {
		return "spring-cassandra Service is UP";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
