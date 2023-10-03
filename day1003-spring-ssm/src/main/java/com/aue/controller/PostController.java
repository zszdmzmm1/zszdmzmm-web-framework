package com.aue.controller;

import com.aue.pojo.Post;
import com.aue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("test")

    @ResponseBody
    public List<Post> test(){
        return postService.test();
    }
}
