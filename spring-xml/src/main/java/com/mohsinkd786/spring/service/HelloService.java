package com.mohsinkd786.spring.service;

public class HelloService {

	private String text;
	private int index;

	public HelloService(String text) {
		System.out.println("Object Created");
		this.text = text;
	}

	public HelloService(String text, int index) {
		this.index = index;
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public int getIndex() {
		return this.index;
	}
}
