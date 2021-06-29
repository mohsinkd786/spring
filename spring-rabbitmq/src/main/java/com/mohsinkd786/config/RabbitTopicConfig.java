package com.mohsinkd786.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mohsinkd786.config.RabbitMqSettings.*;

@Configuration
public class RabbitTopicConfig {

    @Bean
    public Declarables topicBindings(){
        Queue queue1 = new Queue(TOPIC_USER_QUEUE);
        Queue queue2 = new Queue(TOPIC_EMPLOYEE_QUEUE);

        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE);

        Binding binding1 = BindingBuilder.bind(queue1).to(topicExchange).with(BINDING_PATTERN_UNEMPLOYED);
        Binding binding2 = BindingBuilder.bind(queue2).to(topicExchange).with(BINDING_PATTERN_EMPLOYED);

        return new Declarables(queue1,queue2,topicExchange,binding1,binding2);
    }
}
