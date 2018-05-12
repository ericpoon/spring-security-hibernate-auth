package com.demo.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/managers")
    public String showManagerPage() {
        return "managers";
    }

    @GetMapping("/system")
    public String showSystemPage() {
        return "system";
    }

}
