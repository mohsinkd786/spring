package com.mohsinkd786.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class HelloConfiguration {

	@Autowired
	private DiscoveryClient client;

	@Value("${hello.service.endpoint}")
	private String helloWorldServiceId;

	public String getHelloMessageURI(){
		// get service instances
		List<ServiceInstance> instances = client.getInstances(helloWorldServiceId);
		ServiceInstance instance = instances.get(0);
		String uri = instance.getUri() + "/message";
		return uri;
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
