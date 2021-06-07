package com.mohsinkd786.controller;

import com.mohsinkd786.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private List<UserDto> userDtoList= new ArrayList<>();


    @GetMapping
    public ResponseEntity<List> findUsers() {
        userDtoList.add(new UserDto(1,"User 1"));
        userDtoList.add(new UserDto(2,"User 2"));
        userDtoList.add(new UserDto(3,"User 3"));

        return ResponseEntity.ok(userDtoList);
    }
}
