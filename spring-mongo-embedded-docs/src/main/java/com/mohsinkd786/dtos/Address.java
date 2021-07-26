package com.mohsinkd786.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Address {

    private String city;
    private String state;
    private String zipCode;
}
