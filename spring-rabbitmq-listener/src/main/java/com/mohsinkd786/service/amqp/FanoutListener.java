package com.mohsinkd786.service.amqp;

import com.mohsinkd786.config.AmqpQueues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutListener {

    Logger logger = LoggerFactory.getLogger(FanoutListener.class);

    @RabbitListener(queues = AmqpQueues.FANOUT_USER_QUEUE)
    public void onUserMessage(String message){
        logger.info("User - Fanout "+message);
    }

    @RabbitListener(queues = AmqpQueues.FANOUT_EMPLOYEE_QUEUE)
    public void onEmployeeMessage(String message){
        logger.info("User - Fanout "+message);
    }
}
