package com.aue.controller;

import com.aue.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @GetMapping("demo/interceptor")
    public R interceptor() {
        System.out.println("InterceptorController.interceptor");
        return R.ok();
    }
}
