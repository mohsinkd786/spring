package com.mohsinkd786.java.spring.repo;

import com.mohsinkd786.java.spring.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
