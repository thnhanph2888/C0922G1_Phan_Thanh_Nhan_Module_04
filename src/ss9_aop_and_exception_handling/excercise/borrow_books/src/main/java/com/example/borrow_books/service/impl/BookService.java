package com.example.borrow_books.service.impl;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Page<Book> getList(Pageable pageable) {
        return bookRepository.getListBook(pageable);
    }

    @Override
    public boolean setQuality(int quality, int id) {
        return bookRepository.setQuality(quality, id);
    }

    @Override
    public int getQuality(int id) {
        return bookRepository.getQuality(id);
    }

    @Override
    public boolean save(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void pay() {

    }
}
