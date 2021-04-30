package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * 程序功能
 * 用户类接口，定义一些方法供实现类进行重写，包含如下几项功能
 * 1.根据用户名查找
 * 2.根据用户名和密码进行查找
 * 3.对用户信息进行提交
 */
public interface UserDao {

    /**
     * 根据用户名执行数据库的查询操作
     * @param username 用户的姓名
     * @return 如果返回为null说明没有这个用户的信息
     */
    public User queryUserByUserName(String username);

    /**
     * 根据用户名和密码执行数据库的查询操作
     * @param username 用户的姓名
     * @param password 用户的密码
     * @return 如果为null说明数据库中没有找到，其他说明查找到相应的数据
     */
    public User queryUserByUserNameAndPassword(String username,String password);


    /**
     * 用来保存用户的信息
     * @param user User对象
     * @return 放回 -1 表示插入数据失败
     */
    public int savaUser(User user);
}
