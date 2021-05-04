package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 向数据库中插入数据
     * @param book  经过参数注入的 Book 对象
     * @return  返回 -1 插入失败 返回其他值表示影响的行数
     */
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`store`,`img_path`) values (?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStore(),book.getImg_path());
    }

    /**
     * 根据 id 值 (主键) 删除 book
     * @param id    要删除book的 id 值
     * @return  返回 -1 表示该操作失败，返回其他值表示影响的行数
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    /**
     * 对数据库中的数据进行更新
     * @param book  需要更新的值
     * @return  返回 -1 表示操作失败，返回其他值表示受影响的行数
     */
    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`store`=?,`img_path`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStore(),book.getImg_path(),book.getId());
    }

    /**
     * 根据 id 查询数据库
     * @param id    查询id
     * @return      返回 null 表示请求失败
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,store,img_path from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    /**
     * 查询数据库中所有内容
     * @return 返回 null 表示请求失败
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,author,price,sales,store,img_path from t_book ";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryTotalItems() {
        String sql = "select count(*) from t_book ";
        Number totalItems = (Number) queryForSingleValue(sql);
        return totalItems.intValue();
    }

    @Override
    public List<Book> queryPageItems(Integer pageBegin,Integer pageSize) {
        String sql = "select id,name,author,price,sales,store,img_path from t_book limit ?,?";
        return queryForList(Book.class,sql,pageBegin,pageSize);
    }

    @Override
    public Integer queryTotalItemsByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number totalItems = (Number) queryForSingleValue(sql,min,max);
        return totalItems.intValue();
    }

    @Override
    public List<Book> queryPageItemsByPrice(Integer pageBegin, int pageSize, int min, int max) {
        String sql = "select id,name,author,price,sales,store,img_path from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class,sql,min,max,pageBegin,pageSize);
    }
}
