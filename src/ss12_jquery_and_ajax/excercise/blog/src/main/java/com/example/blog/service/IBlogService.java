package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Blog findById(int id);
    void addOrUpdate(Blog blog);
    void delete(int id);
    Page<Blog> findByNameAndAuthor(String name, String author, Pageable pageable);

    Page<Blog> findBlogByCategory_Id(int id, Pageable pageable);
}
