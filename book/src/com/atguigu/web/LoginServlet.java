package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*获取请求的参数*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        /*判断数据库中是否包含该用户*/
        if(userService.login(new User(null,username,password,null)) != null) {
            /*查询到了数据 说明数据库中找到了对应的数据 登录成功*/
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
        else
        {

            /*没有查询到数据，数据库中没有找到对应的数据 登陆失败 返回登录界面*/
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }
    }
}
