package com.example.blog.repository.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        List<Blog> blogList = null;
        blogList = entityManager.createQuery("from Blog").getResultList();
        return blogList;
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void update(Blog blog) {
        Blog blog1 = findById(blog.getId());
        blog1.setName(blog1.getName());
        blog1.setDate(blog1.getDate());
        blog1.setContent(blog1.getContent());
        entityManager.merge(blog1);
    }

    @Override
    public void delete(int id) {
        Blog blog1 = findById(id);
        entityManager.remove(blog1);
    }
}
