package com.tyza66.toforum.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyza66.toforum.mapper.PostMapper;
import com.tyza66.toforum.pojo.Post;
import com.tyza66.toforum.pojo.PostStract;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public IPage<Post> getByPage(int page, int size) {
        IPage<Post> postPage = postMapper.selectPage(new Page<>(page, size), null);
        return postPage;
    }

    public Boolean savePost(PostStract post, String collectionName){
        mongoTemplate.save(post,collectionName);
        return true;
    }

    public List<PostStract> selectPostStract(String collectionName){
        List<PostStract> postStracts = mongoTemplate.findAll(PostStract.class, collectionName);
        return postStracts;
    }

}
