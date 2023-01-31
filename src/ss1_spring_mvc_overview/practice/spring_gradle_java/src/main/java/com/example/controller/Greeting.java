package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Greeting {
    @GetMapping("/")
    public String greeting() {
        return "/greeting";
    }
}
