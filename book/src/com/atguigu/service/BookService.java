package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 添加图书
     */
    public void addBook(Book book);

    /**
     * 根据 id 更新图书数据
     */
    public void updateBook(Book book);

    /**
     * 根据 id 删除图书
     */
    public void deletBookById(Integer id);

    /**
     * 根据 id 查找图书
     * @return  返回查找值，为 null 说明操作失败
     */
    public Book queryBookById(Integer id);

    /**
     * 查找表中所有的数据
     * @return  返回值为 null 说明操作失败
     */
    public List<Book> queryBooks();


}
