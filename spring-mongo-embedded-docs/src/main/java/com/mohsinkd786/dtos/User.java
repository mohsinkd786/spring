package com.mohsinkd786.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("users")
@Data
public class User {
    @Id
    private String userId = UUID.randomUUID().toString();
    private String username;
    private String password;
}
