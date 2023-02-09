package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

         List<Blog> findBlogByCategoryContaining(Category category);
         Page<Blog> findByNameContaining(String name, Pageable pageable);
         Page<Blog> findBlogByCategory_Id(int id, Pageable pageable);
}
