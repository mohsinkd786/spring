package com.mohsinkd786.controller;

import com.mohsinkd786.dto.ProductDto;
import com.mohsinkd786.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService productService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findProducts(@RequestHeader String message){
        logger.info("$$$$$$$$$$$$$ ",message);

        return productService.findProducts();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @GetMapping("{id}")
    public ProductDto findProductById(@PathVariable("id") String productId){
        return productService.findProductById(productId).get();
    }
}
