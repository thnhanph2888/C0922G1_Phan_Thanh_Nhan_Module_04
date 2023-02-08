package com.example.blog.service;

import com.example.blog.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category findById(int id);
    boolean addOrUpdate(Category category);
    boolean delete(int id);
}
