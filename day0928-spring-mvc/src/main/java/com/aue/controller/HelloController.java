package com.aue.controller;

import com.aue.pojo.User;
import com.aue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping("response/text")
    @ResponseBody
    public String text() {
        return "This just a text.";
    }

    @RequestMapping("response/json")
    @ResponseBody
    public User json() {
        User user = new User();
        user.setName("hjf");
        user.setPassword("secret");
        return user;
    }

    @RequestMapping("response/json-list")
    @ResponseBody
    public List<User> jsonList() {
        User user = new User("hjf", "secret");
        User user1 = new User("lrh", "stupid");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        return userList;
    }

    @RequestMapping(path = "request/mapping-method-get", method = RequestMethod.GET)
    @ResponseBody
    public String mappingMethodGet(String method) {
        return "Method:" + method;
    }
}
