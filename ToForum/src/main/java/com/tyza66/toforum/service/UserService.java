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
        user.setPassword(SecureUtil.md5(user.getPassword()));
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
}
