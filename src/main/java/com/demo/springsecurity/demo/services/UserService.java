package com.demo.springsecurity.demo.services;

import com.demo.springsecurity.demo.dao.UserDao;
import com.demo.springsecurity.demo.entity.Authority;
import com.demo.springsecurity.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void createUser(String name, String password, String[] authorities) {

        if (userDao.getUserByName(name) != null) {
            throw new RuntimeException("User already exists.");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(name, "{bcrypt}" + encodedPassword);
        List<Authority> authorityList = new ArrayList<>();
        for (String authority : authorities) {
            authorityList.add(new Authority(user, authority));
        }
        user.setAuthorities(authorityList);

        userDao.createUser(user); // authority will also be saved due to cascading
    }
}
