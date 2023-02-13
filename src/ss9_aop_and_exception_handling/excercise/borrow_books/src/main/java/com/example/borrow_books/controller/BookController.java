package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowedBook;
import com.example.borrow_books.service.IBookService;
import com.example.borrow_books.service.IBorrowBookService;
import com.example.borrow_books.util.BorrowException;
import com.example.borrow_books.util.PayBackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    public static String getRandomCode() {
        String code = String.valueOf(Math.round(Math.random() * 100000));
        return code;
    }

    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookService borrowBookService;

    @GetMapping("/")
    public String showListBook(Model model, @PageableDefault(size = 4, page = 0) Pageable pageable) {
        model.addAttribute("books", bookService.getList(pageable));
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail_book";
    }

    @GetMapping("/borrow/{idBook}")
    public String borrow(@PathVariable int idBook, RedirectAttributes redirectAttributes) throws BorrowException {
        Book book = bookService.findById(idBook);
        borrowBookService.add(new BorrowedBook(getRandomCode(), book));
        if (bookService.getQuality(idBook) <= 0) {
            throw new BorrowException("");
        }
        book.setQuality(bookService.getQuality(idBook) - 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "mượn sách thành công!");
        return "redirect:/";
    }

    @GetMapping("/listBorrowed")
    public String showListBorrowed(Model model) {
        model.addAttribute("borrowedBooks", borrowBookService.getListBorrowedBook());
        return "listBorrow";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam String code) throws PayBackException {
        if (borrowBookService.findByCode(code) == null) {
            throw new PayBackException("not found");
        }
        BorrowedBook borrowedBook = borrowBookService.findByCode(code);
        Book book = borrowedBook.getBook();
        book.setQuality(book.getQuality() + 1);
        bookService.save(book);
        borrowBookService.delete(borrowedBook);
        return "redirect:listBorrowed";
    }

    @ExceptionHandler(BorrowException.class)
    public String handlerBorrowException() {
        return "error_borrow";
    }
    @ExceptionHandler(PayBackException.class)
    public String handlerExceptionPayBack() {
        return "error_pay";
    }
}
