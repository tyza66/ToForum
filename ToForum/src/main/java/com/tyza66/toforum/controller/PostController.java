package com.tyza66.toforum.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyza66.toforum.pojo.Post;
import com.tyza66.toforum.pojo.PostStract;
import com.tyza66.toforum.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: tyza66
 * Date: 2023/6/6 15:35
 * Github: https://github.com/tyza66
 **/

@Api(tags = "帖子模块")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @ApiOperation("按页数获取帖子")
    @GetMapping("/getByPage")
    public JSON getSomeByPage(@RequestParam Integer now, @RequestParam Integer size) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            IPage<Post> page = postService.getByPage(now, size);
            if (page != null) {
                end.put("code", 200);
                end.put("msg", "获取成功");
                end.put("data", page);
            }
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("帖子中插入信息")
    @PostMapping("/insert")
    public JSON insert(@RequestBody PostStract post) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            Boolean aBoolean = postService.savePost(post, post.getCollectionName());
            if (aBoolean) {
                end.put("code", 200);
                end.put("msg", "插入成功");
            } else {
                end.put("code", 201);
                end.put("msg", "插入失败");
            }
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }
}
