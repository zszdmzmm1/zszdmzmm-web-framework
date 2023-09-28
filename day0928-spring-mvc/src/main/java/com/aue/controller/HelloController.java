package com.aue.controller;

import com.aue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping("/helloSpringWebMvc")
    @ResponseBody
    public String helloController() {
        userService.save();
        System.out.println("HelloController.helloController");
        return "helloSpringWebMvc";
    }

    @RequestMapping("user/param")
    @ResponseBody
    public String param(String name, String password) {
        return "User:" + name + System.lineSeparator() + "Password:" + password;
    }

    @RequestMapping("user/param-not-match")
    @ResponseBody
    public String paramNotMatch(@RequestParam("userName") String name, String password) {
        return "User:" + name + System.lineSeparator() + "Password:" + password;
    }
}
