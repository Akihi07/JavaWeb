package com.atguigu.test;

import org.junit.Test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("Login");
    }
    public void regist(){
        System.out.println("Regist");
    }

    @Test
    public static void main(String[] args) {
    //    通过反射调用类的方法
        String action = "regist";
        try {
            /*获取类中的方法，反射对象*/

            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);
            declaredMethod.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
