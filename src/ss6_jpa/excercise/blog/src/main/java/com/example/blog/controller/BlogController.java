package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String showHome(Model model){
        model.addAttribute("blogs", blogService.findAll());
        return "home";
    }

    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam int id) {
         return new ModelAndView("update", "blog", blogService.findById(id));
    }

    @PostMapping("/submit")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }
    @PostMapping("/view")
    public String view(Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }
}
