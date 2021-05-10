package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
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

        page.setUrl("client/bookServlet?action=page");

        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);

        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") != null)
            stringBuilder.append("&min=").append(req.getParameter("min"));
        if(req.getParameter("max") != null)
            stringBuilder.append("&max=").append(req.getParameter("max"));

        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
