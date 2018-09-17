package com.mohsinkd786.java.spring.services;

import java.util.List;

import com.mohsinkd786.java.spring.entity.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
   // void delete(long id);
}
