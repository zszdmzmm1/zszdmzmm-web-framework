package com.aue.controller;

import com.aue.pojo.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorExampleController {
    @GetMapping("error")
    @ResponseBody
    public R errorExample() {
        int i = 1 / 0;
        return R.ok();
    }
}
