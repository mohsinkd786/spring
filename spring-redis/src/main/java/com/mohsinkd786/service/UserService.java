package com.mohsinkd786.service;

import com.mohsinkd786.entity.User;
import com.mohsinkd786.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> createUser(User user){
//        User user = new User();
//        user.setId("1");
//        user.setAge(20);
//        user.setName("User1");
//        user.setPassword("user@123");
//        user.setSalary(1000);

        // save user in redis
        userRepo.save(user);
        return findAll();
    }

    public List<User> findAll(){
        List<User> users = new ArrayList();
        userRepo.findAll().forEach(user -> users.add(user) );
        return users;
    }
}
