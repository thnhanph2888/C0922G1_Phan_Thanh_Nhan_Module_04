package com.example.borrow_books.repository;

import com.example.borrow_books.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    BorrowedBook findByCode(String code);
}
