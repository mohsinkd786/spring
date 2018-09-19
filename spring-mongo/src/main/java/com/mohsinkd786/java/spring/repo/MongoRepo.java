package com.mohsinkd786.java.spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohsinkd786.java.spring.entity.Product;

public interface MongoRepo extends MongoRepository<Product, String> {

}
