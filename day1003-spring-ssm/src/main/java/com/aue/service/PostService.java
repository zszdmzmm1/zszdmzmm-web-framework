package com.aue.service;

import com.aue.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> selectAllPosts();

    int add(Post post);

    Post selectPostById(int id);

    List<Post> selectPostsByConditions(String keyword, String[] keys);

    void update(Post post);
}
