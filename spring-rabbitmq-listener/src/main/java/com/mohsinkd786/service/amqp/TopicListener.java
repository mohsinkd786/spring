package com.mohsinkd786.service.amqp;

import com.mohsinkd786.config.AmqpQueues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicListener {

    Logger logger = LoggerFactory.getLogger(TopicListener.class);

    @RabbitListener(queues = AmqpQueues.TOPIC_EMPLOYEE_QUEUE)
    public void onEmployed(String message){
        logger.info("Employed  - Topic "+message);
    }

    @RabbitListener(queues = AmqpQueues.TOPIC_USER_QUEUE)
    public void onUnemployed(String message){
        logger.info("Unemployed  - Topic "+message);
    }
}
