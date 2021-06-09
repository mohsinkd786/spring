package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloKubeController {

    @GetMapping
    public Response sayHello(){
        Response response = new Response();
        response.setMessage("Hello & welcome to Kubernetes");
        response.setStatusCode(HttpStatus.OK);

        return response;
    }
}
