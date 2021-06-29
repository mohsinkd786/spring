package com.mohsinkd786.service.amqp.publisher;

import com.mohsinkd786.config.RabbitMqSettings;
import org.springframework.stereotype.Service;

@Service
public class MessageTopicPublisher extends RabbitPublisher {

    public void sendMessage(String message,String routingKey){
        getRabbitTemplate().convertAndSend(RabbitMqSettings.TOPIC_EXCHANGE,routingKey,message);
    }
}
