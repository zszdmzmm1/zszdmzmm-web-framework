package com.aue.service.impl;

import com.aue.dao.PostMapper;
import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> selectAllPosts() {
        return postMapper.selectAll();
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
    public List<Post> selectPostsByConditions(String keyword, String[] keys) {
        /*List<Post> postList = new ArrayList<>();
        for(String key: keys){
            Post post = new Post();
            Field keyField;
            try {
                keyField = post.getClass().getField("keys");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            keyField.setAccessible(true);
            try {
                keyField.set(post, keyword);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            postList.addAll(postMapper.selectByCondition(post));
        }
        return postList;*/
        Map<String, Object> postMap = new HashMap<>();
        for(String key: keys){
            postMap.put(key, keyword);
        }
        return new ArrayList<>(postMapper.selectByCondition(postMap));
    }

    @Override
    public void update(Post post) {
        int id = post.getId();
        postMapper.update(id, post);
    }
}

