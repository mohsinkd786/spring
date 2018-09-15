package com.mohsinkd786.java.spring.services;

public class OperationImpl implements Operation {

	@Override
	public int sum(int i, int j) {
		return i + j;
	}

	@Override
	public int subtract(int i, int j) {
		return i - j;
	}

}
