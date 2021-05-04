package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook(){
        System.out.println(bookDao.addBook(new Book(null, "IELTS", "Cambridge", BigDecimal.valueOf(Double.parseDouble("38.0")), 500, 1000, null)));
    }

    @Test
    public void deleteBookById(){
        System.out.println(bookDao.deleteBookById(22));
    }

    @Test
    public void updateBook(){
        System.out.println(bookDao.updateBook(new Book(21, "IELTS", "Cambridge", BigDecimal.valueOf(Double.parseDouble("38.0")), 500, 1000, null)));
    }

    @Test
    public void queryBookById(){
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks(){
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryTotalItems() {
        System.out.println(bookDao.queryTotalItems());
    }

    @Test
    public void queryPageItems() {
        for (Book book : bookDao.queryPageItems(0, 4)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryTotalItemsByPrice() {
        System.out.println(bookDao.queryTotalItemsByPrice(10,50));
    }

    @Test
    public void queryPageItemsByPrice() {
        for (Book book : bookDao.queryPageItemsByPrice(0, 4,10,50)) {
            System.out.println(book);
        }
    }

}
