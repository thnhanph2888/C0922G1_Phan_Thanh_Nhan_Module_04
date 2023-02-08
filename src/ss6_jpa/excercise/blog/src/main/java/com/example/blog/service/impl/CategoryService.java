package com.example.blog.service.impl;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addOrUpdate(Category category) {
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            return false;
        }
         return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            categoryRepository.delete(findById(id));
        } catch (Exception e) {
            return false;
        }
     return true;
    }
}
