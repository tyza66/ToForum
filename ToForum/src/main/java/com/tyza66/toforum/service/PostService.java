package com.tyza66.toforum.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyza66.toforum.mapper.PostMapper;
import com.tyza66.toforum.pojo.Post;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: tyza66
 * Date: 2023/6/6 15:29
 * Github: https://github.com/tyza66
 **/

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public IPage<Post> getByPage(int page, int size) {
        IPage<Post> postPage = postMapper.selectPage(new Page<>(page, size), null);
        return postPage;
    }
}
