package com.demo.springsecurity.demo.services;

import com.demo.springsecurity.demo.dao.UserDao;
import com.demo.springsecurity.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
