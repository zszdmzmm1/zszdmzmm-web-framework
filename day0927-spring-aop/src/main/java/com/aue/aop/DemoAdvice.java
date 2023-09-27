package com.aue.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdvice {
    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.*())")
    private void pt() {
    }


    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.delete()) || execution(void com.aue.dao.impl.UserDaoImpl.update())")
    private void pt2() {
    }


    @Before("pt()")
    public void startTimeUsingAtBefore() {
        long endTime = System.currentTimeMillis();
        System.out.println("startTime = " + endTime);
    }

    @After("pt2()")
    public void endTimeAtAfter() {
        long endTime = System.currentTimeMillis();
        System.out.println("endTime = " + endTime);
    }
}
