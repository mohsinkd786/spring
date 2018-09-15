package com.mohsinkd786.java.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsinkd786.java.spring.dao.EmployDao;
import com.mohsinkd786.java.spring.entity.Employ;

@Service
public class EmployServiceImpl implements EmployService {

	@Autowired
	private EmployDao userDao;

	@Transactional
	@Override
	public void add(Employ emp) {
		userDao.add(emp);
	}

	@Transactional
	@Override
	public List<Employ> findAll() {
		return userDao.findAll();
	}

	@Transactional
	@Override
	public void update(Employ emp) {
		userDao.update(emp);
	}
}
