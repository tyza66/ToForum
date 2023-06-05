package com.tyza66.toforum.service;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyza66.toforum.mapper.UserMapper;
import com.tyza66.toforum.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/5 16:54
 * Github: https://github.com/tyza66
 **/

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    //注册方法
    public boolean register(User user) {
        user.setPassword(SecureUtil.sha1(user.getPassword()));
        user.setPower("2");
        user.setStatus("0");
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        queryMapper.eq("username", user.getUsername());
        List<User> users = userMapper.selectList(queryMapper);
        if (users.size() >= 1) {
            return false;
        }
        int insert = userMapper.insert(user);
        if (insert >= 1) {
            return true;
        }else {
            return false;
        }
    }

    //登录方法
    public User login(User user) {
        user.setPassword(SecureUtil.sha1(user.getPassword()));
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        queryMapper.eq("username", user.getUsername());
        queryMapper.eq("password", user.getPassword());
        List<User> users = userMapper.selectList(queryMapper);
        if (users.size() >= 1) {
            User user1 = users.get(0);
            user1.setPassword("");
            return user1;
        }else {
            return null;
        }
    }
}
