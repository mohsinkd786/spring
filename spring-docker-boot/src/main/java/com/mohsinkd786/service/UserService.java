package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserDto> users = new ArrayList<>();

    public List<UserDto> getUsers() {
        return users;
    }

    public UserDto createUser(UserDto userDto){
        users.add(userDto);
        return userDto;
    }
}
