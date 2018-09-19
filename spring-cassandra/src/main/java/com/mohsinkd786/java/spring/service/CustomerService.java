package com.mohsinkd786.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsinkd786.java.spring.entity.Customer;
import com.mohsinkd786.java.spring.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> fetchCustomers() {
		return repo.findAll();
	}

	public Customer addCustomer(Customer cust) {
		return repo.save(cust);
	}

	public Customer findCustomerById(String id) {
		return repo.findById(id).get();
	}

	public Customer updateCustomer(Customer cust) {
		return repo.save(cust);
	}
}
