package com.currency_converter_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    private final double EXCHANGE_RATE = 22000;

    @GetMapping("")
    public String showForm() {
        return "home";
    }

    @PostMapping("/convert")
    public ModelAndView convertUsdToVnd(@RequestParam int usd) {
        double vnd = usd * EXCHANGE_RATE;
        ModelAndView modelAndView = new ModelAndView("result", "vnd", vnd);
        return modelAndView;
    }
}
