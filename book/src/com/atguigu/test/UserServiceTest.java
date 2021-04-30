package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    /* 生成 一个 测试实例 */
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"testMan","654321","test@gmail.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin","null")));
    }

    @Test
    public void existsUserName() {
        if(userService.existsUserName("admin")){
            System.out.println("用户名已存在！");
        }else
            System.out.println("用户名可用！");
    }
}