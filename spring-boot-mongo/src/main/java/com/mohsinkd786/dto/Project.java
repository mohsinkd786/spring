package com.mohsinkd786.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Project {

    @Id
    private String pId;
    private String pName;
    private double budget;
    private List<User> users;
}
