package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username  = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("wzg168") && password.equals("123456")){
            /*登录成功*/
            Cookie cookie = new Cookie("username", username);
            /*cookie 一周内有效*/
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            System.out.println("登录成功");
        }else {
            /*登录失败*/
            System.out.println("登录失败");
        }
    }
}
