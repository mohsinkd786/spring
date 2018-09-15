package com.mohsinkd786.java.spring.service;

import java.util.List;

import com.mohsinkd786.java.spring.entity.Employ;

public interface EmployService {
	void add(Employ emp);

	List<Employ> findAll();

	void update(Employ emp);
}
