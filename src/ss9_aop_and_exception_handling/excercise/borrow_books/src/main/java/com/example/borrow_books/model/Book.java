package com.example.borrow_books.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<BorrowedBook> setBorrowedBook;
    private int quality;

    public Book() {
    }

    public Book(int id, String name, Set<BorrowedBook> setBorrowedBook, int quality) {
        this.id = id;
        this.name = name;
        this.setBorrowedBook = setBorrowedBook;
        this.quality = quality;
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

    public Set<BorrowedBook> getSetBorrowedBook() {
        return setBorrowedBook;
    }

    public void setSetBorrowedBook(Set<BorrowedBook> setBorrowedBook) {
        this.setBorrowedBook = setBorrowedBook;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
