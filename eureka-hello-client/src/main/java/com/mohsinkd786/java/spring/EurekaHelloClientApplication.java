package com.mohsinkd786.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaHelloClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHelloClientApplication.class, args);
	}
}
