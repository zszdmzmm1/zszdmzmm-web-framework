package com.aue.controller;

import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("postList")
    @ResponseBody
    public List<Post> selectAllPosts() {
        return postService.selectAllPosts();
    }

    @PostMapping("add")
    @ResponseBody
    public int add(Post post) {
        return postService.add(post);
    }

    @PostMapping(path="article", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String selectPostById(int id) {
        return postService.selectPostById(id);
    }

    @PostMapping("selectByConditions")
    @ResponseBody
    public List<Post> selectPostsByConditions(String keyword, String[] keys) {
        return postService.selectPostsByConditions(keyword, keys);
    }

    @PostMapping("update")
    @ResponseBody
    public void update(Post post) {
        postService.update(post);
    }
}
