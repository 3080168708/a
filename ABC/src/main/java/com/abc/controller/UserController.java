package com.abc.controller;

import com.abc.dao.UserDao;
import com.abc.pojo.User;
import com.abc.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class UserController {
    //注入用户模块业务层
    @Autowired
    UserService userService;

    //注入用户模块dao层
    @Autowired
    UserDao userDao;

    //登录
    @RequestMapping("login")
    public String login(User user,HttpServletRequest request){
        //获取登录的用户
        User shoppingUser = userDao.logins(user);
        //查看获取的用户信息
        System.out.println(shoppingUser);
        //把登录的用户存入session域中
        request.getSession().setAttribute("shoppingUser",shoppingUser);
        //根据登录的结果 跳到对应结果的页面 false:继续登录 true:商城首页
        return userService.login(user)?"index":"login";
    }

    //用户注册
    @RequestMapping("register")
    public String register(User user){
        //注册 返回注册结果
        boolean register = userService.register(user);
        System.out.println(register);
        //true:登录页面 false:注册页面
        return userService.register(user)?"login":"register";
    }

    //修改密码
    @RequestMapping("setPassword")
    public String setPassword(User user){
        //修改结果 true:登录页面 false:修改页面
        return userService.setPassword(user)?"login":"SetPassword";
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

}
