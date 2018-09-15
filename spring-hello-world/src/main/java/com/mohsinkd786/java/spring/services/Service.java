package com.mohsinkd786.java.spring.services;

import java.util.List;

public interface Service {

	public List<String> fetchAll();

	public String fetchOne(String message);

	public String fetchOne(int index);

	public List<String> add(String message);

}
