package com.mohsinkd786.dto;

import java.util.UUID;

public class ProductDto {
    private String productId = UUID.randomUUID().toString();
    private String name;
    private double price;

    public ProductDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
