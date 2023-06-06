package com.tyza66.toforum.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: tyza66
 * Date: 2023/6/6 18:40
 * Github: https://github.com/tyza66
 **/

@Api(tags = "路由模块")
@Controller
public class RouteController {
    @GetMapping("/post")
    public String post() {
        return "post";
    }


}
