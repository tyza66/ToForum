package com.tyza66.toforum.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyza66.toforum.mapper.PostMapper;
import com.tyza66.toforum.pojo.Post;
import com.tyza66.toforum.pojo.PostStract;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/6 15:29
 * Github: https://github.com/tyza66
 **/

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private MongoTemplate mongoTemplate;

    //分页查询最新的帖子
    public IPage<Post> getByPage(int page, int size) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("last");
        IPage<Post> postPage = postMapper.selectPage(new Page<>(page, size), queryWrapper);
        return postPage;
    }

    //分页查询最新发布的的帖子
    public IPage<Post> getNewByPage(int page, int size) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("first");
        IPage<Post> postPage = postMapper.selectPage(new Page<>(page, size), queryWrapper);
        return postPage;
    }

    //分页查询管理员的帖子
    public IPage<Post> getAdminByPage(int page, int size) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("owner", "admin");
        queryWrapper.orderByDesc("last");
        IPage<Post> postPage = postMapper.selectPage(new Page<>(page, size), queryWrapper);
        return postPage;
    }

    //保存帖子体
    public Boolean savePost(PostStract post, String collectionName) {
        mongoTemplate.save(post, collectionName);
        return true;
    }

    //查询帖子体集合
    public List<PostStract> selectPostStract(String collectionName) {
        List<PostStract> postStracts = mongoTemplate.findAll(PostStract.class, collectionName);
        return postStracts;
    }

    //发布新帖子
    public Boolean send(Post post, PostStract postStract) {
        int insert = postMapper.insert(post);
        mongoTemplate.save(postStract, "post" + post.getId());
        if (insert >= 1) {
            return true;
        } else {
            return false;
        }
    }

    //根据id查询帖子
    public Post getById(int id) {
        Post post = postMapper.selectById(id);
        return post;
    }

    //根据id删除帖子
    public Boolean deleteById(String id) {
        int i = postMapper.deleteById(id);
        mongoTemplate.dropCollection("post" + id);
        if (i >= 1) {
            return true;
        } else {
            return false;
        }
    }

    //根据标题查询帖子
    public List<Post> getByTitle(String title) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        List<Post> posts = postMapper.selectList(queryWrapper);
        return posts;
    }

    //根据tag查询帖子
    public List<Post> getByTag(String tag) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("tags", tag);
        List<Post> posts = postMapper.selectList(queryWrapper);
        return posts;
    }

    //回复帖子
    public Boolean reply(PostStract postStract, String collectionName) {
        mongoTemplate.save(postStract, collectionName);
        return true;
    }

    //根据id删除帖子体
    public Boolean deletePostStractById(String collectionName, String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        mongoTemplate.remove(Query.query(criteria), collectionName);
        return true;
    }

    //按id查询帖子体
    public PostStract selectPostStractById(String collectionName, String id) {
        Criteria criteria = Criteria.where("id").is(id);
        PostStract postStract = mongoTemplate.findOne(Query.query(criteria), PostStract.class,collectionName);
        return postStract;
    }

    //根据id获取帖子体
    public PostStract getPostStractById(String collectionName, String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        PostStract postStract = mongoTemplate.findOne(Query.query(criteria), PostStract.class,collectionName);
        return postStract;
    }

    //按id编辑帖子体
    public Boolean editPostStractById(String collectionName, String id, PostStract postStract) {
        Criteria criteria = Criteria.where("_id").is(id);
        Update update = new Update().set("in", postStract.getIn()).set("last",new Timestamp(System.currentTimeMillis()).toString());
        mongoTemplate.updateFirst(Query.query(criteria), update, collectionName);
        return true;
    }

}
