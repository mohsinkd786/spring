package com.mohsinkd786.repository;

import com.mohsinkd786.dto.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project,String> {
}
