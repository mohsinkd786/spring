package com.mohsinkd786.service.amqp.publisher;

import org.springframework.stereotype.Service;

@Service
public class MessageAmqpPublisher extends RabbitPublisher{

    public void sendMessage(String queue, String routingKey,String message){
        getRabbitTemplate().setRoutingKey(routingKey);
        getRabbitTemplate().convertAndSend(queue,message);
    }
}
