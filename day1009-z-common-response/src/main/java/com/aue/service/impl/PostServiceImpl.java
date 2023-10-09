package com.aue.service.impl;

import com.aue.dao.PostMapper;
import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> selectPostsByPage(int page, int perPage) {
        return postMapper.selectPostsByPage((page - 1) * perPage, perPage);
    }

    @Override
    public int add(Post post) {
        return postMapper.add(post);
    }

    @Override
    public String selectPostById(int id) {
        Post post = postMapper.selectById(id);
        Parser parser = Parser.builder().build();
        Node document = parser.parse(post.getContent());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    @Override
    public List<Post> selectPostsByConditions(Post post) {
        return new ArrayList<>(postMapper.selectByConditionWithDynamicSql(post));
    }

    @Override
    public void update(int id, Post post) {
        post.setId(id);
        postMapper.update(post);
    }

    @Override
    public void delete(int id) {
        postMapper.deleteById(id);
    }

    @Override
    public List<Post> selectPostsAndUser() {
        return postMapper.selectPostsAndUser();
    }
}

