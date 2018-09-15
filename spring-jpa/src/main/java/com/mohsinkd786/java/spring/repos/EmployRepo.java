package com.mohsinkd786.java.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohsinkd786.java.spring.entities.Employ;

public interface EmployRepo extends JpaRepository<Employ, Integer> {

}
