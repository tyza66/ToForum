package com.tyza66.toforum.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyza66.toforum.pojo.Post;
import com.tyza66.toforum.pojo.PostStract;
import com.tyza66.toforum.pojo.User;
import com.tyza66.toforum.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

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

    @ApiOperation("按页数获取热门帖子")
    @GetMapping("/getNowByPage")
    public JSON getSomeHotByPage(@RequestParam Integer now, @RequestParam Integer size) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            IPage<Post> page = postService.getNewByPage(now, size);
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

    @ApiOperation("按页数获取管理员帖子")
    @GetMapping("/getAdminByPage")
    public JSON getSomeAdminByPage(@RequestParam Integer now, @RequestParam Integer size) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            IPage<Post> page = postService.getAdminByPage(now, size);
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

    //根据标题查询帖子
    @ApiOperation("根据标题查询帖子")
    @GetMapping("/getByTitle")
    public JSON getByTitle(@RequestParam String title) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Post> posts = postService.getByTitle(title);
            if (posts.size() != 0) {
                end.put("code", 200);
                end.put("msg", "获取成功");
                end.put("data", posts);
            } else {
                end.put("code", 203);
                end.put("msg", "没有信息");
                end.put("data", posts);
            }
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("按tag查询帖子")
    @GetMapping("/getByTag")
    public JSON getByTag(@RequestParam String tag) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Post> posts = postService.getByTag(tag);
            if (posts.size() != 0) {
                end.put("code", 200);
                end.put("msg", "获取成功");
                end.put("data", posts);
            } else {
                end.put("code", 203);
                end.put("msg", "没有信息");
                end.put("data", posts);
            }
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("帖子中插入帖子体")
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

    @ApiOperation("发布新帖子")
    @PostMapping("/insertNew")
    public JSON sendPost(@RequestBody Post post, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            post.setId(IdUtil.simpleUUID());
            post.setOwner(((User) session.getAttribute("user")).getUsername());
            post.setFirst(new Timestamp(System.currentTimeMillis()));
            post.setLast(new Timestamp(System.currentTimeMillis()));
            post.setMongo("post" + post.getId());
            PostStract postStract = new PostStract();
            postStract.setLast(post.getLast().toString());
            postStract.setFirst(post.getFirst().toString());
            postStract.setTags(post.getTags());
            postStract.setTitle(post.getTitle());
            postStract.setOwner(post.getOwner());
            postStract.setIn(post.getDescription());
            Boolean aBoolean = postService.send(post, postStract);
            if (aBoolean) {
                end.put("code", 200);
                end.put("msg", "发布成功");
                end.put("id", post.getMongo());
            } else {
                end.put("code", 201);
                end.put("msg", "发布失败");
            }
        } else {
            end.put("code", 202);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("回复帖子")
    @PostMapping("/reply")
    public JSON reply(@RequestBody PostStract reply, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            reply.setId(IdUtil.simpleUUID());
            reply.setOwner(((User) session.getAttribute("user")).getUsername());
            reply.setFirst(new Timestamp(System.currentTimeMillis()).toString());
            reply.setLast(new Timestamp(System.currentTimeMillis()).toString());
            Boolean aBoolean = postService.reply(reply, reply.getCollectionName());
            if (aBoolean) {
                end.put("code", 200);
                end.put("msg", "回复成功");
            } else {
                end.put("code", 201);
                end.put("msg", "回复失败");
            }
        } else {
            end.put("code", 202);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("根据id删除评论")
    @GetMapping("/deleteReply")
    public JSON deleteReply(@RequestParam String id, @RequestParam String collectionName, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            Boolean aBoolean = false;
            //只有帖子体的所有者或者超级管理员才能删除
            if (postService.selectPostStractById(collectionName, id).getOwner().equals(((User) session.getAttribute("user")).getUsername()) || ((User) session.getAttribute("user")).getPower().equals("0")) {
                aBoolean = postService.deletePostStractById(collectionName, id);
            }
            if (aBoolean) {
                end.put("code", 200);
                end.put("msg", "删除成功");
            } else {
                end.put("code", 201);
                end.put("msg", "删除失败");
            }
        } else {
            end.put("code", 202);
            end.put("msg", "未登录");
        }
        return end;
    }

    @ApiOperation("根据集合名和帖子id还有帖子体修改帖子")
    @PostMapping("/updatePost")
    public JSON updatePost(@RequestBody PostStract postStract, @RequestParam String id, HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            Boolean aBoolean = false;
            //只有帖子体的所有者或者超级管理员才能修改
            if (postService.selectPostStractById(postStract.getCollectionName(), id).getOwner().equals(((User) session.getAttribute("user")).getUsername()) || ((User) session.getAttribute("user")).getPower().equals("0")) {
                aBoolean = postService.editPostStractById(postStract.getCollectionName(), id, postStract);
            }
            if (aBoolean) {
                end.put("code", 200);
                end.put("msg", "修改成功");
            } else {
                end.put("code", 201);
                end.put("msg", "修改失败");
            }
        } else {
            end.put("code", 202);
            end.put("msg", "未登录");
        }
        return end;

    }
}
