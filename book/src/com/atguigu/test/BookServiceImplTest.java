package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "CET-6", "Zh-CN", BigDecimal.valueOf(Double.parseDouble("40.0")), 500, 1000, null));
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(48, "CET-6", "Zh-CN", BigDecimal.valueOf(Double.parseDouble("45.0")), 500, 1000, null));
    }

    @Test
    public void deletBookById() {
        bookService.deletBookById(23);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}