package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

public class UerDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUserName(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int savaUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
