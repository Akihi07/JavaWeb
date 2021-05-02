package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            //获得业务字符串
            String action = req.getParameter("action");

            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        // 每次需要用if else 判断不利于代码的维护， 采用反射的方式获取对应的方法
        if(action.equals("regist")) {
            regist(req,resp);
        }
        else if(action.equals("login")){
            login(req,resp);
        }
         */
    }


}
