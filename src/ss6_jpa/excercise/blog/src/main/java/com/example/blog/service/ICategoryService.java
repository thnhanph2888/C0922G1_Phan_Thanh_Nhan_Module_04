package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category findById(int id);
    boolean addOrUpdate(Category category);
    boolean delete(int id);

}
