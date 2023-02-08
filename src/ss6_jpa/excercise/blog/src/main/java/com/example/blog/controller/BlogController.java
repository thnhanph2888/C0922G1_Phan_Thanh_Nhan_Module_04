package com.example.blog.controller;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private  IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/")
    public String showHome(@RequestParam(required = false, defaultValue = "") String nameSearch, Model model
            , @PageableDefault(size = 2, page = 0, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findByName(nameSearch, pageable));
        return "blog/home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/add";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/showUpdate/{id}")
    public String showUpdate(Model model, @PathVariable int id) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        blogService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "delete success!");
        return "redirect:/";
    }

    @PostMapping("/save")
    public String addOrUpdate(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.addOrUpdate(blog);
        redirectAttributes.addFlashAttribute("mess", "save success!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewCategory(@PathVariable int id, Model model) {
        model.addAttribute("blogs", categoryService.findById(id).getBlogSet());
        return "blog/home";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String nameSearch, Model model
            , @PageableDefault(size = 2, page = 0, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findByName(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        return "blog/home";
    }
}
