package com.aue.controller;

import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableTransactionManagement
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("posts")
    @ResponseBody
    public List<Post> index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int perPage) {
        return postService.selectPostsByPage(page, perPage);
    }

    @PostMapping("posts")
    @ResponseBody
    public int store(@RequestBody Post post) {
        return postService.add(post);
    }

    @GetMapping("posts/{id}")
    @ResponseBody
    public String show(@PathVariable int id) {
        return postService.selectPostById(id);
    }


    @PutMapping("posts/{id}")
    @ResponseBody
    public void update(@PathVariable int id, @RequestBody Post post) {
        postService.update(id, post);
    }

    @DeleteMapping("posts/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    @PostMapping("posts/search")
    @ResponseBody
    public List<Post> search(@RequestBody Post post) {
        return postService.selectPostsByConditions(post);
    }
}