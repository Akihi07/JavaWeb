package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user 用户类实例
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user  用户实例
     * @return      如果返回为 null 说明登录失败，如果返回有值，说明登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param UserName
     * @return  返回 True 表示存在 不可用 返回 False 表示不存在 可用
     */
    public Boolean existsUserName(String UserName);
}
