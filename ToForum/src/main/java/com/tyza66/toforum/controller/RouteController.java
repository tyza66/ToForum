package com.tyza66.toforum.controller;

import com.tyza66.toforum.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: tyza66
 * Date: 2023/6/6 18:40
 * Github: https://github.com/tyza66
 **/

@Api(tags = "路由模块")
@Controller
public class RouteController {
    @Autowired
    PostService postService;

    @GetMapping("/post")
    public String post(@RequestParam String id,@RequestParam String num, Model model) {

        model.addAttribute("title", "kkk");
        return "post";
    }

}
