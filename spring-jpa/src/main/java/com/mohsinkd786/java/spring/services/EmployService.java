package com.mohsinkd786.java.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mohsinkd786.java.spring.entities.Employ;
import com.mohsinkd786.java.spring.repos.EmployRepo;

@Component
public class EmployService {

	@Autowired
	private EmployRepo repo;

	public List<Employ> findAll() {
		return repo.findAll();
	}

	public void saveOrUpdate(Employ employ) {
		repo.save(employ);
	}

	public Employ findOne(int id) {
		return repo.findById(id).get();
	}
}
