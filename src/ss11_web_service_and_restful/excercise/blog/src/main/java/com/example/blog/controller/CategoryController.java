package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/list_category";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("category", new Category());
        return "category/add_category";
    }
    @GetMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable int id,Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/add_category";
    }

    @PostMapping("/save")
    public String addOrUpdate(Category category) {
        categoryService.addOrUpdate(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/category/list";
    }
}
