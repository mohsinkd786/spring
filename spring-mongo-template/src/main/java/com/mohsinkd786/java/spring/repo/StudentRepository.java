package com.mohsinkd786.java.spring.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mohsinkd786.java.spring.entity.Student;

@Repository
public class StudentRepository {

	@Autowired
	MongoTemplate template;

	public List<Student> findAll() {
		return template.findAll(Student.class);
	}

	public List<Student> findStudentsByName(String studentName) {
		return template.find(Query.query(Criteria.where("name").is(studentName)), Student.class);
	}

	public void insert(Student st) {
		template.insert(st);
	}
}
