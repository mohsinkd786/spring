package com.mohsinkd786.service;

import com.mohsinkd786.dto.Catalog;
import com.mohsinkd786.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<ProductDto> productDtos = new ArrayList<>();

    public List<ProductDto> findProducts(){
        return productDtos;
    }

    public ProductDto createProduct(ProductDto productDto){
        productDtos.add(productDto);
        return productDto;
    }

    public Optional<ProductDto> findProductById(String productId){
        return productDtos
                .stream()
                .filter(p -> p.getProductId().equalsIgnoreCase(productId))
                .findFirst();
    }

    public Catalog getCatalog(){

        Catalog catalog = new Catalog();
        catalog.setProducts(productDtos);
        catalog.setTotal(productDtos.size());
        return catalog;
    }
}
