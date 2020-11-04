package com.abc.service;

import com.abc.dao.UserDao;
import com.abc.pojo.Goods;
import com.abc.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//用户模块Service层
@Service
//加载配置Spring文件
@ContextConfiguration(locations={"classpath:spring/spring.xml"} )
public class UserService {
    //注入用户模块的dao层
    @Autowired
    UserDao userDao;

        /**
         * 用户登录
         * @param user 输入的用户名和密码
         * @return false:失败 true:成功
         */
        public boolean login(User user){return userDao.logins(user)==null?false:true;}

        /**
         * 用户注册
         * @param user 输入的用户名和密码
         * @return false:注册失败 true:注册成功
         */
        public boolean register(User user){
            //根据注册的用户名判断用户是否存在
            if (userDao.getUser(user.getUsername())==null){
            //不存在 进行注册 返回true
                userDao.register(user);
                return true;
            }else{
            //存在 返回false
                return false;
            }
        }

    /**
     * 修改密码
     * @param user 输入的用户名和新密码
     * @return false:注册失败 true:注册成功
     */
    public boolean setPassword(User user){
            //判断要修改密码的用户名 是否存在
            if(userDao.getUser(user.getUsername())!=null){
            //用户名存在 修改当前用户名对应的密码
             userDao.setPassword(user);
            //修改成功 返回true
             return true;
            }else{
            //用户名不存在
                return false;
        }
    }
}
