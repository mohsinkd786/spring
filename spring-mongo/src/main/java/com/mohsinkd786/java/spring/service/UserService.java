package com.mohsinkd786.java.spring.service;

import com.mohsinkd786.java.spring.entity.User;
import com.mohsinkd786.java.spring.repo.UserRepo;
import com.mohsinkd786.java.spring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRepo repo;

    public List<User> findUsers(){
        //return repository.findAll();
        return repo.findAll();
    }

    public List<User> findUsersByName(String name){
        return repo.findUsersByName(name);
    }

    public User createUser(User user){
        return repository.save(user);
    }

}
