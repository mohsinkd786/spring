package com.mohsinkd786.service;

import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.sqs.publisher.UserPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserPublisher userPublisher;

    @Autowired
    public UserService(UserPublisher userPublisher) {
        this.userPublisher = userPublisher;
    }

    public boolean sendUserToQueue(UserDto userDto){
        return userPublisher.sendMessage(userDto);
    }
}
