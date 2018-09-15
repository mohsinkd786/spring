package com.mohsinkd786.java.spring.dao;

import java.util.List;

import com.mohsinkd786.java.spring.entity.Employ;

public interface EmployDao {
	void add(Employ emp);

	List<Employ> findAll();

	void update(Employ emp);
}
