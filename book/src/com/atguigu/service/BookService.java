package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

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

    /**
     * 用来处理分页相关业务
     * @param pageNo         当前页码数
     * @param pageSize     当前页面显示数量
     * @return  返回一个Page对象，内部包含所有查询信息
     */
    public Page<Book> page(int pageNo, int pageSize);

    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
