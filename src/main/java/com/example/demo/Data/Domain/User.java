package com.example.demo.Data.Domain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends Entity<String> {
    private String email;
    private String username;
}