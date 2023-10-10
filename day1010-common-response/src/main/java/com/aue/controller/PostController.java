package com.aue.controller;

import com.aue.pojo.User;
import com.aue.util.R;
import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("posts")
    public R index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int perPage) {
        return R.ok(postService.selectPostsByPage(page, perPage));
    }

    @PostMapping("posts")
    public R store(@RequestBody Post post) {
        return R.ok(postService.add(post));
    }

    @GetMapping("posts/{id}")
    public R show(@PathVariable int id) {
        return R.ok(postService.selectPostById(id));
    }


    @PutMapping("posts/{id}")
    public R update(@PathVariable int id, @RequestBody Post post) {
        return R.ok(postService.update(id, post));
    }

    @DeleteMapping("posts/{id}")
    public R delete(@PathVariable int id) {
        return R.ok(postService.delete(id));
    }

    @PostMapping("posts/search")
    public R search(@RequestBody Post post) {
        return R.ok(postService.selectPostsByConditions(post));
    }

    @GetMapping("posts/co-search")
    public R coSearch() {
        return R.ok(postService.selectPostsAndUser());
    }

    @PostMapping("users")
    public R store(@Validated @RequestBody User user) {
        return R.ok(user);
    }
}