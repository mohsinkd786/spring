package com.mohsinkd786.controller;

import com.mohsinkd786.dtos.Message;
import com.mohsinkd786.service.MessageSnsPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private MessageSnsPublisherService messageSnsPublisherService;

    @Autowired
    public void setMessageSnsPublisherService(MessageSnsPublisherService messageSnsPublisherService) {
        this.messageSnsPublisherService = messageSnsPublisherService;
    }

    @GetMapping("/status")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Service is running ");
    }

    @PostMapping("/message/publish")
    public ResponseEntity publishMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageSnsPublisherService.sendMessageToTopic(message));
    }

    @PostMapping("/message/subscriber/{email}")
    public ResponseEntity addSubscriber(@PathVariable String email){
        return ResponseEntity.ok(messageSnsPublisherService.addSubscriber(email));
    }
}
