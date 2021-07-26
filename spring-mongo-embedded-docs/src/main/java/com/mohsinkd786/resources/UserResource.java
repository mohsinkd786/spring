package com.mohsinkd786.resources;

import com.mohsinkd786.dtos.User;
import com.mohsinkd786.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return service.save(user);
    }
}
