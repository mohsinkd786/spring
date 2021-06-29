package com.mohsinkd786.service;

import com.mohsinkd786.service.amqp.publisher.MessageTopicPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private MessageTopicPublisher messageTopicPublisher;

    @Autowired
    public void setMessageTopicPublisher(MessageTopicPublisher messageTopicPublisher) {
        this.messageTopicPublisher = messageTopicPublisher;
    }

    public boolean sendMessage(String message){
        messageTopicPublisher.sendMessage(message,"topic.employed.msg");
        return true;
    }
}
