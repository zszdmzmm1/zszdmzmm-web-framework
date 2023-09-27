package com.aue.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdvice {
    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.*())")
    private void pt() {
    }


    @Before("pt()")
    public void startTimeUsingAtBefore() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);
    }
}
