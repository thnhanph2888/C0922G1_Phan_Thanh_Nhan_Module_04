package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String name, Pageable pageable);
    Blog findById(int id);
    void addOrUpdate(Blog blog);
    void delete(int id);
    Page<Blog> findByName(String name, Pageable pageable);
}
