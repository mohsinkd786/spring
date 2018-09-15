package com.mohsinkd786.java.spring.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entity.Employ;
import com.mohsinkd786.java.spring.entity.services.EmployService;

@RestController
public class EmployController {

	@Autowired
	private EmployService service;

	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	@RequestMapping("/employs")
	public List<Employ> emps() {
		return service.emps();
	}
}
