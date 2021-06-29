package com.mohsinkd786.service.amqp.publisher;

import com.mohsinkd786.config.RabbitMqSettings;
import org.springframework.stereotype.Service;

@Service
public class MessageFanoutPublisher extends RabbitPublisher {

    public void sendMessage(String message){
        getRabbitTemplate().convertAndSend(RabbitMqSettings.FANOUT_EXCHANGE,"",message);
    }
}
