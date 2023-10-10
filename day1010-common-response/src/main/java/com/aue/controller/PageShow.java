package com.aue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageShow {
    @GetMapping("page-show")
    public String pageShow(Model model) {
        model.addAttribute("content", "notEmpty");
        return "page";
    }
}
