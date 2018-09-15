package com.mohsinkd786.java.spring.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixHelloConsumerService {

	@Value("${eureka.service.url}")
	private String url;

	@HystrixCommand(fallbackMethod = "localMessage")
	public String message() {

		RestTemplate restTemplate = new RestTemplate();

		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return restTemplate.getForObject(uri, String.class);
	}

	private String localMessage() {
		return "Hystrix Hello Message, seems Hello Service is Down";
	}
}
