package com.mohsinkd786.controller;

import com.mohsinkd786.service.FanoutService;
import com.mohsinkd786.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/messages")
@RestController
public class MessageController {

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private FanoutService fanoutService;

    @Autowired
    public void setFanoutService(FanoutService fanoutService) {
        this.fanoutService = fanoutService;
    }
    @PostMapping("/fanout")
    public ResponseEntity<Boolean> sendFanoutMessage(@RequestBody String message){
        return ResponseEntity.ok(fanoutService.sendMessage(message));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> sendMessageToQueue(@RequestBody String message){
        return ResponseEntity.ok(messageService.sendMessage(message));
    }
}
