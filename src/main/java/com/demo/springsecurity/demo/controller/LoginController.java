package com.demo.springsecurity.demo.controller;

import com.demo.springsecurity.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @GetMapping("/login")
    public String showLoginForm() {

        System.out.println(userDao.getUsers());

        return "login-form";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
