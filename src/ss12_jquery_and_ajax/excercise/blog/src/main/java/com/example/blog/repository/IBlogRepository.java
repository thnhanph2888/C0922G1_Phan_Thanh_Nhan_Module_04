package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
         @Query(value = "select * from blog where id = :id_blog", nativeQuery = true)
         Blog findById(@Param("id_blog") int id);

         List<Blog> findBlogByCategoryContaining(Category category);
         Page<Blog> findByNameContainingAndAuthorContaining(String name,String author, Pageable pageable);
         Page<Blog> findBlogByCategory_Id(int id, Pageable pageable);
}
