package com.mohsinkd786.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/home")
@RestController
public class HomeResource {

    @GetMapping
    public String sayHello(){
        return "Home Controller";
    }
}
