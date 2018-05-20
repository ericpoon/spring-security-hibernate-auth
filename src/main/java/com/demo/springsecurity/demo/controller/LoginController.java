package com.demo.springsecurity.demo.controller;

import com.demo.springsecurity.demo.entity.User;
import com.demo.springsecurity.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor); // fixme: this will also trim password
    }

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
        try {
            userService.createUser(user.getUsername(), user.getPassword(), new String[]{"ROLE_EMPLOYEE"});
        } catch (Exception e) {
            return "redirect:/register?error";
        }

        return "login-form";
    }
}
