package com.mohsinkd786.repos;

import com.mohsinkd786.dtos.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    @Query("{'address.city' : ?0 }")
    List<Employee> findEmployeesByCity(String city);
}
