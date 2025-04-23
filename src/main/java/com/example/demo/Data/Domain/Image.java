package com.example.demo.Data.Domain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image extends Entity<String> {
    private String name;
    private byte[] content;
}