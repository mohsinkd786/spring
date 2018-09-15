package com.mohsinkd786.java.spring.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mohsinkd786.java.spring.EmployDao;
import com.mohsinkd786.java.spring.entity.Employ;

@Component
public class EmployService {

	@Autowired
	private EmployDao dao;

	public List<Employ> emps() {
		return dao.getEmploys();
	}
}
