package com.demo.springsecurity.demo.services;

import com.demo.springsecurity.demo.dao.UserDao;
import com.demo.springsecurity.demo.entity.Authority;
import com.demo.springsecurity.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = new User(name, "{noop}" + password);
        List<Authority> authorityList = new ArrayList<>();
        for (String authority : authorities) {
            authorityList.add(new Authority(user, authority));
        }
        user.setAuthorities(authorityList);

        System.out.println("creating user");

        userDao.createUser(user); // authority will also be saved due to cascading
    }
}
