package com.mohsinkd786.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Employee {

    @JsonIgnore
    @Id
    private int id;
    private String employeeId = UUID.randomUUID().toString();
    private String firstName;
    private String email;
    private double salary;
}
