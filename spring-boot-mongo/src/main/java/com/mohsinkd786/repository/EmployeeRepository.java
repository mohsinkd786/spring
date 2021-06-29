package com.mohsinkd786.repository;

import com.mohsinkd786.dto.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    Employee findByEmployeeId(String eId);

    List<Employee> findByFirstNameIsLike(String name);

    @Query("{ 'firstName': ?0 }")
    List<Employee> findEmployByFirstName(String firstName);

    @Query("{ 'salary': { $gte: ?0, $lte: ?1 } }")
    List<Employee> findEmploysBySalaryBetween(double salaryGte, double salaryLte);

    @Query(value = "{}", fields = "{ firstName: 1, _id: 0}")
    List<Employee> findFirstNameAndExcludeEmployeeId();
}
