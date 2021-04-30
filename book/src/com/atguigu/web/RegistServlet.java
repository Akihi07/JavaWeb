package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    /**
     * 由于Servlet只能调用Service层的服务，所以在Servlet层需要调用 UserService接口 实现类 的 实例方法
     */
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.获取请求参数*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        /*2.检查验证码是否正确 当前写死要求 要求验证码为abcde*/
        if("abcde".equalsIgnoreCase(code)){

            /*检查用户名是否可用*/
            if(userService.existsUserName(username))
            {
                /*3.检查用户名是否可用*/
                /*返回True 用户名已存在 不可用*/
                System.out.println("用户名[" + username + "]已被占用！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else
            {
                /*返回false 用户名不存在 可用*/
                /*保存用户信息到数据库*/
                userService.registUser(new User(null,username,password,email));

                /*返回注册成功的地址*/
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }
        else {

            /*验证码不正确，返回注册界面*/
            System.out.println("验证码["+ code + "]错误" );
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

        }


    }
}
