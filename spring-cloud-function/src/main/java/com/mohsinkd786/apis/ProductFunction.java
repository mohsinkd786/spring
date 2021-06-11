package com.mohsinkd786.apis;

import com.mohsinkd786.Product;

import java.util.function.Supplier;

public class ProductFunction implements Supplier<Product> {

    @Override
    public Product get() {
        Product product=new Product();
        product.setId(1);
        product.setName("Iphone 12");

        return product;
    }
}

