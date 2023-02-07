package com.example.blog.repository;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    void update(Blog blog);
    void delete(int id);
}
