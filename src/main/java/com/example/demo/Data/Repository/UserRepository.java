package com.example.demo.Data.Repository;

import com.example.demo.Data.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}