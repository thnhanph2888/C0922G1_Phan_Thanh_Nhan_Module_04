package com.example.borrow_books.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Longer {
     private static int count;
     @Pointcut("execution(* com.example.borrow_books.controller.BookController.borrow(..))")
     public void borrow() {
     }

     @After(value = "borrow()")
     public void print() {
          System.out.println("mượn sách................");
     }

     @Pointcut("execution(* com.example.borrow_books.controller.BookController.payBook(..))")
     public void giveBack() {
     }

     @After(value = "giveBack()")
     public void printAction() {
          System.out.println("trả sách................");
     }

     @Pointcut("execution(* com.example.borrow_books.controller.BookController.*(..))")
     public void openLibrary() {
     }

     @After(value = "openLibrary()")
     public void count() {
          count++;
          System.out.println("Số người ghé thăm là: " + count );
     }
}
