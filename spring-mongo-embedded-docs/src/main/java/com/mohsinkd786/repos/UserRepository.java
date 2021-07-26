package com.mohsinkd786.repos;

import com.mohsinkd786.dtos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
