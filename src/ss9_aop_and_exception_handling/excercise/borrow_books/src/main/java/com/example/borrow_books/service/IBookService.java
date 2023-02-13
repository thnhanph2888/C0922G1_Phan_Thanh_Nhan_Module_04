package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Book findById(int id);
    Page<Book> getList(Pageable pageable);
    boolean setQuality(int quality, int id);
    int getQuality( int id);
    boolean save(Book book);
    void pay();
}
