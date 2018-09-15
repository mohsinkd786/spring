package com.mohsinkd786.java.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class MessageService implements Service {

	private static List<String> msgs = new ArrayList<String>();
	static {
		msgs.add("Hello");
		msgs.add("Hi");
		msgs.add("Hey");
	}

	@Override
	public List<String> fetchAll() {
		return msgs;
	}

	@Override
	public String fetchOne(String message) {
		return msgs.stream().filter(m -> m.equalsIgnoreCase(message)).collect(Collectors.toList()).get(0);
	}

	@Override
	public String fetchOne(int index) {
		return msgs.get(index);
	}

	@Override
	public List<String> add(String message) {
		msgs.add(message);
		return msgs;
	}

}
