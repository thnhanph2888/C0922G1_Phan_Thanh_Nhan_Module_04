package com.simple_dictionary.controller;

import com.simple_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("")
    public String showHome() {
        return "dictionary";
    }

    @PostMapping("/search")
    public String search(@RequestParam String vocabulary, Model model) {
        model.addAttribute("word", dictionaryService.findVocabulary(vocabulary));
        return "dictionary";
    }

    @PostMapping("")
    public String search() {
        return "dictionary";
    }
}
