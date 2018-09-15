package com.mohsinkd786.java.spring.feign.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ibm-hello-service", fallback = HelloFeignClient.HelloFallBack.class)
public interface HelloFeignClient {

	@RequestMapping("/message")
	public String message();

	@Component
	public class HelloFallBack {
		public String localMessage() {
			return "Hello Feign Client, Service seems to be down ";
		}
	}
}
