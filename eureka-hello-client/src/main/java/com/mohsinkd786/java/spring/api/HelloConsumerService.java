package com.mohsinkd786.java.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloConsumerService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hello.service.endpoint}")
	private String url;

	public String getMessage() {
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}
}
