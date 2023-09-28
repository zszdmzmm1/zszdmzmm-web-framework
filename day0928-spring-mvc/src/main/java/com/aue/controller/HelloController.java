package com.aue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/helloSpringWebMvc")
    @ResponseBody
    public String helloController() {
        return "helloSpringWebMvc";
    }
}
