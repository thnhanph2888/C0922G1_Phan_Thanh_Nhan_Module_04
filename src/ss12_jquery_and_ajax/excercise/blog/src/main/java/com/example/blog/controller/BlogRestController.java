package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> getAllBlog(@RequestParam(required = false, defaultValue = "") String nameSearch
    , @RequestParam(required = false, defaultValue = "") String authorSearch
            ,@RequestParam(required = false, defaultValue = "4") int number) {
        Pageable pageable = PageRequest.of(0, number);
        Page<Blog> blogList = blogService.findByNameAndAuthor(nameSearch, authorSearch, pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Set<Blog>> findBlogByCategory(@PathVariable int id) {
        Set<Blog> blogList = categoryService.findById(id).getBlogSet();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
    }

    @GetMapping("/blog/search")
    public ResponseEntity<Page<Blog>> findBlogByName(@RequestParam(required = false, defaultValue = "") String name
            , @RequestParam(required = false, defaultValue = "") String author
            , @RequestParam(required = false, defaultValue = "2") int number) {
        Pageable pageable = PageRequest.of(0, number);
        Page<Blog> blogs = blogService.findByNameAndAuthor(name, author, pageable);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }
}
