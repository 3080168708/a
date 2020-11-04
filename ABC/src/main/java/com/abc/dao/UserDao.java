package com.abc.dao;

import com.abc.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //登录
    User logins(User user);

    //注册
    void register(User user);

    //修改密码
    void setPassword(User user);

    //查询要注册的用户名是否存在
    User getUser(String username);
}
