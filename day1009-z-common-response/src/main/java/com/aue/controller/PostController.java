package com.aue.controller;

import com.aue.pojo.CommonResponse;
import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("posts")
    public CommonResponse index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int perPage) {
        return CommonResponse.ok(postService.selectPostsByPage(page, perPage));
    }

    @PostMapping("posts")
    public CommonResponse store(@RequestBody Post post) {
        return CommonResponse.ok(postService.add(post));
    }

    @GetMapping("posts/{id}")
    public CommonResponse show(@PathVariable int id) {
        return CommonResponse.ok(postService.selectPostById(id));
    }


    @PutMapping("posts/{id}")
    public CommonResponse update(@PathVariable int id, @RequestBody Post post) {
        return CommonResponse.ok(postService.update(id, post));
    }

    @DeleteMapping("posts/{id}")
    public CommonResponse delete(@PathVariable int id) {
        return CommonResponse.ok(postService.delete(id));
    }

    @PostMapping("posts/search")
    public CommonResponse search(@RequestBody Post post) {
        return CommonResponse.ok(postService.selectPostsByConditions(post));
    }

    @GetMapping("posts/co-search")
    public CommonResponse coSearch() {
        return CommonResponse.ok(postService.selectPostsAndUser());
    }
}