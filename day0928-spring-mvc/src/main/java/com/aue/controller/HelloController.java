package com.aue.controller;

import com.aue.pojo.User;
import com.aue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @RequestMapping("user/param-pojo")
    @ResponseBody
    public String paramPojo(User user) {
        return user.toString();
    }

    @RequestMapping("user/body-pojo")
    @ResponseBody
    public String bodyPojo(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("user/date-time-format")
    @ResponseBody
    public String dateTimeFormat(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date2) {
        return "date:" + date.toString() + System.lineSeparator() +
                "date2:" + date2.toString();
    }

    @RequestMapping("response/page")
    public String page() {
        return "../index.jsp";
    }
}
