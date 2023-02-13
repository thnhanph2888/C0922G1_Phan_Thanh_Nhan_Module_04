package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowedBook;

import java.util.List;

public interface IBorrowBookService {
    boolean add(BorrowedBook borrowedBook);
    List<BorrowedBook> getListBorrowedBook();

    boolean delete(BorrowedBook borrowedBook);
    BorrowedBook findByCode(String code);
}
