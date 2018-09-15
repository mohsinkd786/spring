package com.mohsinkd786.java.spring;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mohsinkd786.java.spring.entity.Employ;
import com.mohsinkd786.java.spring.service.EmployService;

public class Application {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfiguration.class);

		EmployService service = context.getBean(EmployService.class);

		 service.findAll().forEach(System.out::println);
		 service.add(new Employ(25, "Robert", "rob@gmail.com", 78000));
		service.update(new Employ(24, "Bob", "jh@jj.com", 754320));
		context.close();
	}
}
