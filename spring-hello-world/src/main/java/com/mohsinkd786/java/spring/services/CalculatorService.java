package com.mohsinkd786.java.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculatorService {

	@Autowired
	private Operation operate;

	@Autowired
	private ValidatorService validator;

	public int calculate(String i, String j, OperationType type) {
		int ii = validator.toInt(i);
		int jj = validator.toInt(j);
		switch (type) {
		case ADD:
			return operate.sum(ii, jj);
		case SUBTRACT:
			return operate.subtract(ii, jj);
		default:
			return 0;
		}
	}
}
