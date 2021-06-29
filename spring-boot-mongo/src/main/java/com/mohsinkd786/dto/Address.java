package com.mohsinkd786.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Address {
    private String city;
    private String street;
    private String zipCode;
}
