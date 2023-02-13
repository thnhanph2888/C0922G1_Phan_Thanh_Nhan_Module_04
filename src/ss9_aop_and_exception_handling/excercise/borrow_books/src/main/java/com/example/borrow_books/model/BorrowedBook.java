package com.example.borrow_books.model;

import javax.persistence.*;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowedBook() {
    }

    public BorrowedBook(int id, String code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public BorrowedBook(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
