package com.ibm.java.spring.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

	@GetMapping("/message")
	public String message() {
		return "Hello how r u";
	}
}
