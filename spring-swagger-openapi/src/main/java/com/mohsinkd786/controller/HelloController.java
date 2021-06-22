package com.mohsinkd786.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/health")
    public String healthCheck(){
        return "Welcome to Spring with OpenAPI / Swagger 3";
    }
}
