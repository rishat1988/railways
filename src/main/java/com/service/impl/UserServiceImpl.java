package com.service.impl;


import com.dao.UserDao;
import com.model.Role;
import com.model.User;
import com.dao.RoleDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> role = new HashSet<>();
        role.add(roleDao.getByName("ROLE_USER"));
        user.setRoles(role);
        userDao.add(user);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

//    public void userRegistration(User date) {
//        User user = new User ();
//
//        Date datee = null;
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            datee = dateFormat.parse("date_of_birth");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        user.setDateOfBirth(datee);
//        add(user);
//    }

@Override
  public  List<User> allUsers(){return userDao.allUsers();}

    @Override
    public void delete(User user){ userDao.delete(user);}

    @Override
    public void update(User user){ userDao.update(user);}

    @Override
    public User getById(int id){return userDao.getById(id);}

}