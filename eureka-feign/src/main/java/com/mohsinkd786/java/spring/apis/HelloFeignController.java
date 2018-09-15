package com.mohsinkd786.java.spring.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.feign.clients.HelloFeignClient;

@RestController
@RequestMapping("/feign")
public class HelloFeignController {

	@Autowired
	private HelloFeignClient client;

	@RequestMapping("/hello/message")
	public String hello() {
		return client.message();
	}

	@RequestMapping("/hello/status")
	public String status() {
		return "Service is UP";
	}
}