package com.config.controller;

import com.config.model.ConfigEmail;
import com.config.service.ipml.ConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfigController {

    @Autowired
    ConfigEmailService configEmailService;

    private static String[] listLanguage = {"English", "Vietnamese", "Japanese", "Chinese"};
    private static int[] listPageSize = {5,10,15,20};

    @ModelAttribute("languages")
    public String[] getLanguages() {
        return listLanguage;
    }
    @ModelAttribute("pageSizes")
    public int[] getListPageSize() {
        return listPageSize;
    }

    @GetMapping
    public String showHome(Model model) {
        model.addAttribute("listConfig", configEmailService.getList());
        return "home";
    }

    @GetMapping("update")
    public String showSetting(@RequestParam int id, Model model) {
        model.addAttribute("config", configEmailService.findById(id));
        return "setting";
    }

    @PostMapping("submit")
    public String update(@ModelAttribute ConfigEmail configEmail, Model model) {
        configEmailService.Save(configEmail);
        return "redirect: list";
    }
}
