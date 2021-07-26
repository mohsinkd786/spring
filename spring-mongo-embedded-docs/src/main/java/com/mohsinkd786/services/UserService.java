package com.mohsinkd786.services;

import com.mohsinkd786.dtos.User;
import com.mohsinkd786.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
    public User save(User user){
        return repository.save(user);
    }
}
