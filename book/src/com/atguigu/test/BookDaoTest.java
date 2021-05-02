package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

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

}
