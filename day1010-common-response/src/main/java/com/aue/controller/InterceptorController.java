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

    @GetMapping("demo/interceptor-plus")
    public R interceptor2() {
        System.out.println("InterceptorController.interceptor2");
        return R.ok();
    }

    @GetMapping("demo/interceptor-fail")
    public R interceptor3() {
        int num = 1 / 0;
        return R.ok();
    }
}
