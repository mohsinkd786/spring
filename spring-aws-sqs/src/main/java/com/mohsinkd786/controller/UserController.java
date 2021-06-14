package com.mohsinkd786.controller;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/user/publish")
    public boolean sendUserToQueue(@RequestBody UserDto userDto){
        return userService.sendUserToQueue(userDto);
    }
}
