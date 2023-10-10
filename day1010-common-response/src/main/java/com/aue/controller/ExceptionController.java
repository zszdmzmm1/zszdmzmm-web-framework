package com.aue.controller;

import com.aue.pojo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public R exception(Exception e){
        return R.fail(e.getClass().getSimpleName() + e.getMessage());
    }
}
