package com.example.borrow_books.repository;


import com.example.borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book", nativeQuery = true)
    Page<Book> getListBook(Pageable pageable);

    @Query(value = "select * from book where id = :id", nativeQuery = true)
    Book findById(@Param("id") int id);

    @Query(value = "update book set quality = ?1 where id = ?2", nativeQuery = true)
    boolean setQuality(int quality, int id);

    @Query(value = "select quality from book where id = :id", nativeQuery = true)
    int getQuality(@Param("id") int id);
}
