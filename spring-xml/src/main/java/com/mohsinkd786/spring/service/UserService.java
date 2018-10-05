package com.mohsinkd786.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	private String message;

	@Autowired
	private UtilService utilService;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public int execute(int i, int j) {
		return this.utilService.sum(i, j);
	}
}
