package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void addOrUpdate(Blog blog) {
       blogRepository.save(blog);
    }
    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(int id, Pageable pageable) {
        return blogRepository.findBlogByCategory_Id(id, pageable);
    }
}
