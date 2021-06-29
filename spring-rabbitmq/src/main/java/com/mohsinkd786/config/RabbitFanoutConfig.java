package com.mohsinkd786.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.mohsinkd786.config.RabbitMqSettings.*;

@Configuration
public class RabbitFanoutConfig {

    @Bean
    public Declarables fanoutBindings(){
        Queue queue1 = new Queue(FANOUT_USER_QUEUE);
        Queue queue2 = new Queue(FANOUT_EMPLOYEE_QUEUE);
        Queue queue3 = new Queue(FANOUT_CANDIDATE_QUEUE);

        FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE);

        Binding binding1 = BindingBuilder.bind(queue1).to(fanoutExchange);
        Binding binding2 = BindingBuilder.bind(queue2).to(fanoutExchange);
        Binding binding3 = BindingBuilder.bind(queue3).to(fanoutExchange);

        return new Declarables(queue1,queue2,queue3,fanoutExchange, binding1,binding2,binding3);
    }
}
