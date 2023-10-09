package com.aue.service;

import com.aue.pojo.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {

    List<Post> selectPostsByPage(int page, int perPage);

    @Transactional
    int add(Post post);

    String selectPostById(int id);

    List<Post> selectPostsByConditions(Post post);
    @Transactional
    void update(int id, Post post);
    @Transactional
    void delete(int id);

    List<Post> selectPostsAndUser();
}
