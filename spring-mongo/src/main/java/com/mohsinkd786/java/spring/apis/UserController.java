package com.mohsinkd786.java.spring.apis;

import com.mohsinkd786.java.spring.entity.User;
import com.mohsinkd786.java.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> findUsers(){
        return userService.findUsers();
    }

    @PostMapping("/filter")
    public List<User> findUsersByName(@RequestBody String name){
        return userService.findUsersByName(name);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
