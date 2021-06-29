package com.mohsinkd786.java.spring.api;

import com.mohsinkd786.java.spring.HelloConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloConsumerService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HelloConfiguration configuration;

	@Value("${hello.service.endpoint}")
	private String url;

	public String getMessageOld() {
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

	public String getMessage(){
		String response = restTemplate.getForObject(configuration.getHelloMessageURI(),String.class);
		return response;
	}
}
