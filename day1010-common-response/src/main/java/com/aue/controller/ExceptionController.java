package com.aue.controller;

import com.aue.exception.BusinessException;
import com.aue.exception.SystemException;
import com.aue.pojo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BusinessException.class)
    public R businessException(BusinessException e){
        //send log
        //...
        return R.fail(e.getClass().getSimpleName() + ":" + e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public R systemException(SystemException e){
        //send log
        //send email
        //...
        return R.fail(e.getClass().getSimpleName() + ":" + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exception(Exception e){
        return R.fail(e.getClass().getSimpleName() + ":" + e.getMessage());
    }
}
