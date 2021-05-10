package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        if(cart != null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        Integer count = WebUtils.parseInt(req.getParameter("count"),0);

        if(cart != null){
            cart.updateCount(id,count);
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*获取书的 id*/
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        /*数据库中找到该书*/
        Book book = bookService.queryBookById(id);

        /*将图书信息转换为 cartItem 对象*/
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice());

        /*尝试获取 session 域中的 cart对象*/
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        /*如果没有 cart 对象 创建一个*/
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        //实现主页显示最后添加的一项商品
        req.getSession().setAttribute("lastBook",cartItem.getName());

        /* 重定向到当前页面 */
        //System.out.println(req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clearCart();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
