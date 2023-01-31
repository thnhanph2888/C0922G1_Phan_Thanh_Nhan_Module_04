package com.example.controller;

import com.example.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private Hello hello;
    @GetMapping("hello")
    public String hello() {
        String str = hello.getName();
         return str;
    }
}
