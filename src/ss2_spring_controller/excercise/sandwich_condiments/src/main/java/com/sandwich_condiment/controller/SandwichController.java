package com.sandwich_condiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("")
    public String showHome() {
        return "home";
    }

    @PostMapping("/choose")
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        return new ModelAndView("home", "condimentList", condiment);
    }
}
