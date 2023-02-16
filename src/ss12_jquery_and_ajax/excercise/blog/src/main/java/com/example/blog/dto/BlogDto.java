package com.example.blog.dto;
import com.example.blog.model.Category;

import javax.validation.constraints.NotBlank;

public class BlogDto {
    private int id;
    @NotBlank(message = "ai cho bạn để trống")
    private String name;
    private String date;
    private String author;
    private String content;
    private Category category;
    public BlogDto() {
    }

    public BlogDto(int id, String name, String date, String author, String content, Category category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
