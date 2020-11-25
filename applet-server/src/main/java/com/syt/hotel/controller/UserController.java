package com.syt.hotel.controller;

import com.syt.hotel.dao.SytUserMapper;
import com.syt.hotel.dao.UserMapper;
import com.syt.hotel.model.SytUser;
import com.syt.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 0200077
 * @create 2018-10-30 16:22
 **/
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SytUserMapper sytUserMapper;

    @RequestMapping("insert")
    public void insert(){
        User user = new User();
        user.setAge(11);
        user.setMobile("13650096499");
        user.setPassword("111111");
        user.setUserName("蔡金陆");
        userMapper.insertUser(user);
    }

    @RequestMapping("get")
    public User get(){
        return userMapper.findOne(1L);
    }

    @RequestMapping("get_user")
    public SytUser get1(){
        return sytUserMapper.selectByPrimaryKey(1L);
    }
}
