package com.aue.service;

import com.aue.pojo.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {

    List<Post> selectPostsByPage(int page, int perPage);

    @Transactional
    int add(Post post);

    String selectPostById(int id);

    List<Post> selectPostsByConditions(String keyword, String[] keys);
    @Transactional
    void update(int id, Post post);
    @Transactional
    void delete(int id);
}
