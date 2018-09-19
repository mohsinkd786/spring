package com.mohsinkd786.java.spring.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entity.Product;
import com.mohsinkd786.java.spring.service.MongoService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private MongoService service;

	@GetMapping("/status")
	public String status() {
		return "Product Service is UP";
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return service.findAll();
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return service.insert(product);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.save(product);
	}
}
