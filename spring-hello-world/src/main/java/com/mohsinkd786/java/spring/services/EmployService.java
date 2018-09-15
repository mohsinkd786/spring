package com.mohsinkd786.java.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mohsinkd786.java.spring.entities.Employ;
import com.mohsinkd786.java.spring.repos.EmployRepo;

@Component
public class EmployService {

	@Autowired
	private EmployRepo repo;

	public List<Employ> fetchAll() {

		Iterable<Employ> itr = repo.findAll();

		List<Employ> emps = new ArrayList<Employ>();
		itr.forEach(e -> {
			emps.add(e);
		});
		return emps;
	}

	public List<Employ> findBySalary(int salary) {
		return repo.findBySalary(salary);
	}
}
