package com.mohsinkd786.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("employees")
@Data
public class Employee {
    @Id
    private String empId = UUID.randomUUID().toString();
    private String eName;
    private double salary;
    private Address address;
    @DBRef
    private User user;
}
