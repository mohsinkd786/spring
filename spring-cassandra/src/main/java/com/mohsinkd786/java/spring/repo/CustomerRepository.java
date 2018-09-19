package com.mohsinkd786.java.spring.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.mohsinkd786.java.spring.entity.Customer;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer, String> {

}
