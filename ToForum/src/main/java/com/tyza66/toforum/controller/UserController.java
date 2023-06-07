package com.tyza66.toforum.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.toforum.pojo.User;
import com.tyza66.toforum.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/6/5 16:53
 * Github: https://github.com/tyza66
 **/
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public JSON register(@RequestBody User user, @RequestParam String code, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        String qr = (String) session.getAttribute("qr");
        boolean register = false;
        if (qr.equals(code)) {
            register = userService.register(user);
            if (register) {
                end.put("code", 200);
                end.put("msg", "注册成功");
            } else {
                end.put("code", 201);
                end.put("msg", "注册失败");
            }
        }else {
            end.put("code", 202);
            end.put("msg", "验证码错误");
        }

        return end;
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public JSON login(@RequestBody User user, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        User login = userService.login(user);
        if (login != null) {
            end.put("code", 200);
            end.put("msg", "登录成功");
            end.put("data", login);
            StpUtil.login(login.getPower());
            session.setAttribute("user", login);
        } else {
            end.put("code", 201);
            end.put("msg", "登录失败");
        }
        return end;
    }

    @ApiOperation("用户注销")
    @GetMapping("/logoff")
    public JSON logoff() {
        JSONObject end = JSONUtil.createObj();
        StpUtil.logout();
        end.put("code", 200);
        end.put("msg", "注销成功");
        return end;
    }

    @ApiOperation("检查登录状态")
    @GetMapping("/check")
    public JSON check(HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            end.put("code", 200);
            end.put("msg", "已登录");
            end.put("permissionList", StpUtil.getPermissionList());
            end.put("roleList", StpUtil.getRoleList());
            end.put("role", StpUtil.getLoginId());
            end.put("username", ((User) session.getAttribute("user")).getUsername());
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("获取验证码")
    @GetMapping("/qr")
    public void getQr(HttpServletRequest request, HttpServletResponse response) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 25);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            lineCaptcha.write(response.getOutputStream());
            String code = lineCaptcha.getCode();
            request.getSession().setAttribute("qr", code);
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
