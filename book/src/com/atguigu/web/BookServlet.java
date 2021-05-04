package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();


    /**
     * 处理分页的业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    /**
     * 往数据库里面添加数据
     * 添加数据后重定向至数据显示界面
     * @param req   请求对象
     * @param resp  返回对象
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBeam(req.getParameterMap(),new Book());
        bookService.addBook(book);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        /*此处注意 ，如果采用请求转发的方式，按下快捷键F5时，浏览器会重复提交最后一次的请求，会造成多次添加*/
        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        pageNo++;
        /*因此需要采用重定向的方式*/
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 从数据库删除数据
     * 前端通过reconfirm绑定
     * 后端删除后需要重定向至显示界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取需要删除图书的 id
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        //数据库中删除
        bookService.deletBookById(id);

        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBeam(req.getParameterMap(),new Book());
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 获取对应的 book 的 id
        * 根据 id 去数据库查询数据
        * 将得到的数据添加到 request 域中
        * 最后将请求转发到参数修改的页面
        * */
        req.setAttribute("book",bookService.queryBookById(WebUtils.parseInt(req.getParameter("id"),0)));
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    /**
     * 数据显示界面，点击图书管理链接首先访问Servlet
     * 执行数据库查询后将数据放在request域中返回
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //    通过service查询数据库中所有的数据
        List<Book> books = bookService.queryBooks();

        //    将图书数据保存在request域中
        req.setAttribute("books",books);

        //    请求转发到book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
