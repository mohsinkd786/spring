package com.mohsinkd786.java.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.services.Service;

@RestController
public class IndexController {

	@Autowired
	private Service service;

	@RequestMapping("/messages")
	public List<String> fetchAll() {
		return service.fetchAll();
	}

	@RequestMapping(path = "/message", method = RequestMethod.POST)
	public String fetchOne(String message) {
		return service.fetchOne(message);
	}

	@RequestMapping(path = "/message/{index}")
	public String fetchOne(@PathVariable int index) {
		return service.fetchOne(index);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public List<String> add(String message) {
		return service.add(message);
	}
}
