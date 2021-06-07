package com.mohsinkd786.dto;

import java.util.List;

public class Catalog {
    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private List<ProductDto> products;

    private int total;
}
