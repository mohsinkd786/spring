package com.mohsinkd786;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringEurekaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaProducerApplication.class, args);
	}

}
