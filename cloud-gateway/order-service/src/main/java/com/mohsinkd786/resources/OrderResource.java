package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderResource {

    @GetMapping
    public String message(){
        return "Order Service";
    }
}
