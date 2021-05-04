package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
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

    /**
     * 创建 page 对象，并进行返回
     * @param pageNo         当前页码数
     * @param pageSize     当前页面显示数量
     * @return 返回经过 service 层处理后的数据
     */
    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        page.setTotalItems(bookDao.queryTotalItems());
        page.setPageTotal((int) Math.ceil(page.getTotalItems().doubleValue() / page.getPageSize().doubleValue()));

        //访问越界判断
        if(pageNo < 1)
            pageNo = 1;
        else if(pageNo > page.getPageTotal())
            pageNo = page.getPageTotal();
        page.setPageNo(pageNo);


        Integer pageBegin = (pageNo - 1) * pageSize;

        page.setPageItems(bookDao.queryPageItems(pageBegin,pageSize));
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {

        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        page.setTotalItems(bookDao.queryTotalItemsByPrice(min,max));
        page.setPageTotal((int) Math.ceil(page.getTotalItems().doubleValue() / page.getPageSize().doubleValue()));

        //访问越界判断
        if(pageNo < 1)
            pageNo = 1;
        else if(pageNo > page.getPageTotal())
            pageNo = page.getPageTotal();
        page.setPageNo(pageNo);


        Integer pageBegin = (pageNo - 1) * pageSize;

        page.setPageItems(bookDao.queryPageItemsByPrice(pageBegin,pageSize,min,max));
        return page;
    }
}
