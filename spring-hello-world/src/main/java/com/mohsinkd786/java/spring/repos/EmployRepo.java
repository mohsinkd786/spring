package com.mohsinkd786.java.spring.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mohsinkd786.java.spring.entities.Employ;

public interface EmployRepo extends CrudRepository<Employ, Integer> {

	@Query("SELECT emp_id,name,email,p_id,salary FROM employs WHERE salary > :salary")
	List<Employ> findBySalary(@Param("salary") int salary);
}
