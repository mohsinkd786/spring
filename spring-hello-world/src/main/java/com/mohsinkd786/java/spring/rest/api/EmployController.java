package com.mohsinkd786.java.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entities.Employ;
import com.mohsinkd786.java.spring.services.EmployService;

@RestController
public class EmployController {

	@Autowired
	private EmployService service;

	@RequestMapping("/employs")
	public List<Employ> fetchAll() {
		return service.fetchAll();
	}

	@RequestMapping("/employ/{salary}")
	public List<Employ> fetchBySalary(@PathVariable int salary) {
		return service.findBySalary(salary);
	}

}
