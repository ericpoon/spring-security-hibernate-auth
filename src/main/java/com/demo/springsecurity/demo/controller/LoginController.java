package com.demo.springsecurity.demo.controller;

import com.demo.springsecurity.demo.entity.Authority;
import com.demo.springsecurity.demo.entity.User;
import com.demo.springsecurity.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up-form";
    }

    @PostMapping("/register/proceed")
    public String proceedUserSignUp(@ModelAttribute User user) {
        System.out.println("PROCEEDING SIGN UP\n" + user);
        userService.createUser(user.getUsername(), user.getPassword(), new String[]{"ROLE_EMPLOYEE"});

        return "sign-up-form"; // fixme
    }
}
