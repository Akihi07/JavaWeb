package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    /**
     * 新增图书数据
     * @param book      参数注入后的对象
     */
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    /**
     * 根据 id 更新数据库中的数据
     * @param book     参数注入后的对象
     */
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    /**
     * 根据 id 删除数据
     * @param id        需要删除数据的 id
     */
    @Override
    public void deletBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    /**
     * 根据 id 查找数据
     * @param id        需要查找数据的 id
     * @return          返回找到的数据，操作失败返回 null
     */
    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    /**
     * 查找数据库中所有数据
     * @return  返回整个数据库，操作失败返回 null
     */
    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
