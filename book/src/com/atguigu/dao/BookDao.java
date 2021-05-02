package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 向数据库中插入数据
     * @param book  经过参数注入的 Book 对象
     * @return  返回 -1 插入失败 返回其他值表示影响的行数
     */
    public int addBook(Book book);

    /**
     * 根据 id 值 (主键) 删除 book
     * @param id       要删除book的 id 值
     * @return          返回 -1 表示该操作失败，返回其他值表示影响的行数
     */
    public int deleteBookById(Integer id);

    /**
     * 对数据库中的数据进行更新
     * @param book      需要更新的值
     * @return             返回 -1 表示操作失败，返回其他值表示受影响的行数
     */
    public int updateBook(Book book);

    /**
     * 根据 id 查询数据库
     * @param id    查询id
     * @return      返回 null 表示请求失败
     */
    public Book queryBookById(Integer id);

    /**
     * 查询数据库中所有内容
     * @return  返回 null 表示请求失败
     */
    public List<Book> queryBooks();
}
