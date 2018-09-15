package com.mohsinkd786.java.spring.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entities.Employ;
import com.mohsinkd786.java.spring.services.EmployService;

@RestController
public class EmployController {

	@Autowired
	private EmployService service;

	@RequestMapping("/employs")
	public List<Employ> findAll() {
		return service.findAll();
	}

	@RequestMapping(path = "/employ/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public void save(@RequestBody Employ employ) {
		service.saveOrUpdate(employ);
	}

	@RequestMapping(path = "/employ/update", method = RequestMethod.PUT, consumes = MediaType.ALL_VALUE)
	public void update(@RequestBody Employ employ) {
		service.saveOrUpdate(employ);
	}

	@RequestMapping(path = "/employ/{id}", method = RequestMethod.GET)
	public Employ findOne(@PathVariable int id) {
		return service.findOne(id);
	}
}
