package com.mohsinkd786.service;

import com.mohsinkd786.service.amqp.publisher.MessageAmqpPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageAmqpPublisher amqpPublisher;

    @Autowired
    public void setAmqpPublisher(MessageAmqpPublisher amqpPublisher) {
        this.amqpPublisher = amqpPublisher;
    }
    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    public boolean sendMessage(String message){
        amqpPublisher.sendMessage(queueName,routingKey,message);
        return true;
    }
}
