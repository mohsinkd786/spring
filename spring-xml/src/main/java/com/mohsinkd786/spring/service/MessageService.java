package com.mohsinkd786.spring.service;

public class MessageService {

	private HelloService service;

	public void setService(HelloService service) {
		this.service = service;
	}

	public MessageService() {

	}

	public MessageService(HelloService service) {
		this.service = service;
	}

	public void execute() {
		System.out.println("MessageService " + service.getText() + " " + service.getIndex());
	}
}
