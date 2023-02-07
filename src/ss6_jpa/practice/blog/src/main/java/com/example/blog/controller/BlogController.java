package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private  IBlogService blogService;
    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/showUpdate/{id}")
    public String showUpdate(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "delete success!");
        return "redirect:/";
    }

    @PostMapping("/save")
    public String addOrUpdate(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.addOrUpdate(blog);
        redirectAttributes.addFlashAttribute("mess", "save success!");
        return "redirect:/";
    }

}
