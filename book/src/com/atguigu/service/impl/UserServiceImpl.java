package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UerDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;


public class UserServiceImpl implements UserService {

    /*由于 service 层需要对数据库进行操作，因此需要首先产生一个 UserDao 接口实现类 的 实例对象*/
    private UserDao userDao = new UerDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.savaUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existsUserName(String UserName) {
        if(userDao.queryUserByUserName(UserName) == null)
            return false;
        else
            return true;
    }
}
