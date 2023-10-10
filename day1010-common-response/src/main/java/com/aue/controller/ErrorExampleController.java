package com.aue.controller;

import com.aue.exception.BusinessException;
import com.aue.exception.SystemException;
import com.aue.pojo.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorExampleController {
    @GetMapping("error")
    @ResponseBody
    public R errorExample() {
        int i = 1 / 0;
        return R.ok();
    }

    @GetMapping("error/{code}")
    @ResponseBody
    public R errorExample1(@PathVariable String code) throws Exception {
        switch (code) {
            case "99" -> throw new BusinessException("log记录");
            case "999" -> throw new SystemException("发送邮件通知");
        }
        return R.ok();
    }
}
