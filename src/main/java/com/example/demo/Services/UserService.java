package com.example.demo.Services;

import com.example.demo.Data.Domain.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);
    List<User> getAllUsers();
    User updateUser(String id, User user);
    void deleteUser(String id);

}
