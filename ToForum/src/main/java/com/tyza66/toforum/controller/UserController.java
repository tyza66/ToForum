package com.tyza66.toforum.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.toforum.pojo.User;
import com.tyza66.toforum.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/6/5 16:53
 * Github: https://github.com/tyza66
 **/
@Api(tags ="用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public JSON register(@RequestBody User user) {
        JSONObject end = JSONUtil.createObj();
        boolean register = userService.register(user);
        if (register){
            end.put("code",200);
            end.put("msg","注册成功");
        }else{
            end.put("code",201);
            end.put("msg","注册失败");
        }
        return end;
    }
}
