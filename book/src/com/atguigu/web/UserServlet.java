package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class UserServlet extends BaseServlet {

    /**
     * 处理注册的相关业务
     * @param req   请求对象
     * @param resp  返回对象
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();

        /*1.获取请求参数*/

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //properties过多，每次创建新的实例对象的时候需要进行大量赋值
        //采用BeanUtils注入参数

        /*
        for (Map.Entry<String,String[]> entry:req.getParameterMap().entrySet()) {
            System.out.println(entry.getKey() + "=" + Arrays.asList(entry.getValue()));
        }
        */
        User user = (User) WebUtils.copyParamToBeam(req.getParameterMap(),new User());


        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.setAttribute("email",email);
        req.setAttribute("code",code);

        /*2.检查验证码是否正确 当前写死要求 要求验证码为abcde*/
        if("abcde".equalsIgnoreCase(code)){

            /*检查用户名是否可用*/
            if(userService.existsUserName(username))
            {
                /*3.检查用户名是否可用*/
                /*返回True 用户名已存在 不可用*/
                System.out.println("用户名[" + username + "]已被占用！");
                req.setAttribute("msg","用户名已被占用");
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

            req.setAttribute("msg","验证码错误");

            System.out.println("验证码["+ code + "]错误" );
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

        }
    }

    /**
     * 处理登录相关业务
     * @param req   请求对象
     * @param resp  返回对象
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();

        /*获取请求的参数*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        /*判断数据库中是否包含该用户*/
        if(userService.login(new User(null,username,password,null)) != null) {
            /*查询到了数据 说明数据库中找到了对应的数据 登录成功*/
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
        else
        {

            // 由于登陆失败的时候需要返回一些错误信息，所以此处需要返回一些错误信息，利用域方法进行传递
            /*提示错误信息*/
            req.setAttribute("msg","用户名或密码错误！");
            /*回显输入的信息*/
            req.setAttribute("username",username);
            req.setAttribute("password",password);

            /*没有查询到数据，数据库中没有找到对应的数据 登陆失败 返回登录界面*/
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }
    }
}
