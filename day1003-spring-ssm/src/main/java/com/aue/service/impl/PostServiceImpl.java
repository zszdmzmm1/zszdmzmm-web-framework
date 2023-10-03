package com.aue.service.impl;

import com.aue.dao.PostMapper;
import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> test() {
        return postMapper.selectAll();
    }
}
