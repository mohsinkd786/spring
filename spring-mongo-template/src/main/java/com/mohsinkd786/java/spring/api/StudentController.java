package com.mohsinkd786.java.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohsinkd786.java.spring.entity.Student;
import com.mohsinkd786.java.spring.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/all")
	public List<Student> findAll() {
		return service.findAll();
	}

	@GetMapping("/find/{name}")
	public List<Student> findStudentsByName(@PathVariable("name") String studentName) {
		return service.findStudentsByName(studentName);
	}

	@PostMapping("/add")
	public void insert(@RequestBody Student st) {
		service.insert(st);
	}
}
