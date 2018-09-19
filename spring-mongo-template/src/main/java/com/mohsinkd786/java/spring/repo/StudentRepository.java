package com.mohsinkd786.java.spring.repo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
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

	public List<Student> findStudentsbySubjectCode(String subjectCode) {
		MatchOperation operation = match(new Criteria("subjects.code").is(subjectCode));
		ProjectionOperation project = project("name").and("email").previousOperation();
		Aggregation aggregation = newAggregation(operation, project);
		AggregationResults<Student> output = template.aggregate(aggregation, Student.class, Student.class);
		List<Student> studentNames = output.getMappedResults();
		return studentNames;
	}
}
