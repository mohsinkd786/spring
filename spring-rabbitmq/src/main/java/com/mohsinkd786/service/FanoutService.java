package com.mohsinkd786.service;

import com.mohsinkd786.service.amqp.publisher.MessageFanoutPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanoutService {

    private MessageFanoutPublisher messageFanoutPublisher;

    @Autowired
    public void setMessageFanoutPublisher(MessageFanoutPublisher messageFanoutPublisher) {
        this.messageFanoutPublisher = messageFanoutPublisher;
    }

    public boolean sendMessage(String message){
        messageFanoutPublisher.sendMessage(message);
        return true;
    }
}
