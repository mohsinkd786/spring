package com.mohsinkd786.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsinkd786.java.spring.entity.Student;
import com.mohsinkd786.java.spring.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public List<Student> findAll() {
		return repo.findAll();
	}

	public List<Student> findStudentsByName(String studentName) {
		return repo.findStudentsByName(studentName);
	}

	public void insert(Student st) {
		repo.insert(st);
	}

	public List<Student> findStudentsbySubjectCode(String subjectCode) {
		return repo.findStudentsbySubjectCode(subjectCode);
	}
}
