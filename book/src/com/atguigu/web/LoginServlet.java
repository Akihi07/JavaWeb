/*
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

        */
/*获取请求的参数*//*

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        */
/*判断数据库中是否包含该用户*//*

        if(userService.login(new User(null,username,password,null)) != null) {
            */
/*查询到了数据 说明数据库中找到了对应的数据 登录成功*//*

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
        else
        {

            // 由于登陆失败的时候需要返回一些错误信息，所以此处需要返回一些错误信息，利用域方法进行传递
            */
/*提示错误信息*//*

            req.setAttribute("msg","用户名或密码错误！");
            */
/*回显输入的信息*//*

            req.setAttribute("username",username);
            req.setAttribute("password",password);

            */
/*没有查询到数据，数据库中没有找到对应的数据 登陆失败 返回登录界面*//*

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }
    }
}
*/
