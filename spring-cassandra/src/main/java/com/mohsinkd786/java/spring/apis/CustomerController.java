package com.mohsinkd786.java.spring.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entity.Customer;
import com.mohsinkd786.java.spring.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/all")
	public List<Customer> fetchCustomers() {
		return service.fetchCustomers();
	}

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer cust) {
		return service.addCustomer(cust);
	}

	@PutMapping("/edit")
	public Customer updateCustomer(@RequestBody Customer cust) {
		return service.updateCustomer(cust);
	}

	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable String id) {
		return service.findCustomerById(id);
	}

}
