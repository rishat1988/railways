package com.service;

import com.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User findByUsername(String username);
//    void userRegistration(User date);

    List<User> allUsers();

    void delete(User user);

    void update(User user);

    User getById(int id);
//    String encodePassword(String password);
//
//    Boolean checkPassword(User user, String password);
//
//    User getUserById(Long userId);
}