package com.mohsinkd786.controller;

import com.mohsinkd786.dtos.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @GetMapping
    public List<Product> getProducts(){
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return null;
    }
}
