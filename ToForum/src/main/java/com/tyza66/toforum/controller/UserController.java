package com.tyza66.toforum.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.toforum.pojo.User;
import com.tyza66.toforum.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public JSON login(@RequestBody User user) {
        JSONObject end = JSONUtil.createObj();
        User login = userService.login(user);
        if (login!=null){
            end.put("code",200);
            end.put("msg","登录成功");
            end.put("data",login);
            StpUtil.login(login.getPower());
        }else{
            end.put("code",201);
            end.put("msg","登录失败");
        }
        return end;
    }

    @ApiOperation("用户注销")
    @GetMapping("/logoff")
    public JSON logoff() {
        JSONObject end = JSONUtil.createObj();
        StpUtil.logout();
        end.put("code",200);
        end.put("msg","注销成功");
        return end;
    }

    @ApiOperation("检查登录状态")
    @GetMapping("/check")
    public JSON check(){
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()){
            end.put("code",200);
            end.put("msg","已登录");
            end.put("permissionList",StpUtil.getPermissionList());
            end.put("roleList",StpUtil.getRoleList());
            end.put("data",StpUtil.getLoginId());
        }else{
            end.put("code",201);
            end.put("msg","未登录");
        }
        return end;
    }

}
