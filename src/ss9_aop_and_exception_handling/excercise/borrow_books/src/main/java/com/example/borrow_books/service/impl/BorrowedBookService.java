package com.example.borrow_books.service.impl;

import com.example.borrow_books.model.BorrowedBook;
import com.example.borrow_books.repository.IBorrowedBookRepository;
import com.example.borrow_books.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService implements IBorrowBookService {
    @Autowired
    private IBorrowedBookRepository borrowedBookRepository;

    @Override
    public boolean add(BorrowedBook borrowedBook) {
        try {
            borrowedBookRepository.save(borrowedBook);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    @Override
    public List<BorrowedBook> getListBorrowedBook() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public boolean delete(BorrowedBook borrowedBook) {
        try {
            borrowedBookRepository.delete(borrowedBook);
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public BorrowedBook findByCode(String code) {
        return borrowedBookRepository.findByCode(code);
    }
}
