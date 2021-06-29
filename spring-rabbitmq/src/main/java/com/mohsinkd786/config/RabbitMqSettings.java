package com.mohsinkd786.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSettings {

    // Topic Exchange configs
    public final static String TOPIC_USER_QUEUE = "com.mohsinkd786.topic.user";
    public final static String TOPIC_EMPLOYEE_QUEUE = "com.mohsinkd786.topic.employee";
    public final static String TOPIC_EXCHANGE = "com.mohsinkd786.topic.exchange";
    public final static String BINDING_PATTERN_EMPLOYED = "*.employed.*";
    public final static String BINDING_PATTERN_UNEMPLOYED = "#.unemployed";

    // Fanout Exchange configs
    public final static String FANOUT_USER_QUEUE = "com.mohsinkd786.fanout.user";
    public final static String FANOUT_EMPLOYEE_QUEUE = "com.mohsinkd786.fanout.employee";
    public final static String FANOUT_CANDIDATE_QUEUE = "com.mohsinkd786.fanout.candidate";
    public final static String FANOUT_EXCHANGE = "com.mohsinkd786.fanout.exchange";
}
