package com.mohsinkd786.service.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeListener {

    @KafkaListener(topics ="kafka-demo" ,groupId = "group-1")
    public void onMessage(String message){
        System.out.println(message);
    }
}
