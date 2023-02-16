package com.example.blog.controller;
import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String showHome(@RequestParam(required = false, defaultValue = "") String nameSearch
            , @RequestParam(required = false, defaultValue = "") String author, Model model
            , @PageableDefault(size = 5, page = 0, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findByNameAndAuthor(nameSearch, author, pageable));
        return "blog/home";
    }

    @GetMapping("/showAdd")
    public String showAdd(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogDto", new BlogDto());
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
        model.addAttribute("blogDto", blogService.findById(id));
        return "blog/update";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        blogService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "delete success!");
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@Validated BlogDto blogDto, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("blogDto", blogDto);
                return "blog/add";
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.addOrUpdate(blog);
        redirectAttributes.addFlashAttribute("mess", "add success!");
        return "redirect:/";
    }
    @PostMapping("/update")
    public String update(@Validated BlogDto blogDto, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("blogDto", blogDto);
                return "blog/update";
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.addOrUpdate(blog);
        redirectAttributes.addFlashAttribute("mess", "update success!");
        return "redirect:/";
    }

    @GetMapping("/view/{idCategory}")
    public String viewCategory(@PathVariable int idCategory, Model model
            , @PageableDefault(size = 5, page = 0, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("blogs", blogService.findBlogByCategory_Id(idCategory, pageable));
        model.addAttribute("idCategory", idCategory);
        return "blog/home";
    }

    @GetMapping("/search")
    public String searchByNameAndAuthor( Model model, @PageableDefault(size = 5, page = 0, sort = "date", direction = Sort.Direction.DESC)
    Pageable pageable, @RequestParam(required = false, defaultValue = "") String authorSearch, @RequestParam String nameSearch) {
        model.addAttribute("blogs", blogService.findByNameAndAuthor(nameSearch, authorSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("authorSearch", authorSearch);
        return "blog/home";
    }
}
