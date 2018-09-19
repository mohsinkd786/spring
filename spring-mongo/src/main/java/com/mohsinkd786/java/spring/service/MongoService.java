package com.mohsinkd786.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mohsinkd786.java.spring.entity.Product;
import com.mohsinkd786.java.spring.repo.MongoRepo;

@Component
public class MongoService {

	@Autowired
	private MongoRepo repo;

	public List<Product> findAll() {
		return repo.findAll();
	}

	public Product findById(String id) {
		return repo.findById(id).get();
	}

	public Product insert(Product product) {
		return repo.insert(product);
	}

	public Product save(Product product) {
		return repo.save(product);
	}
}
