package com.example.demo.Data.Repository;

import com.example.demo.Data.Domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}