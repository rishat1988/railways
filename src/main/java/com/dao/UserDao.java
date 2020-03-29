package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);

    void add(User user);

    List<User> allUsers();

    void delete(User user);

    void update(User user);

    User getById(int id);

//    User getOne(Long userId);
}