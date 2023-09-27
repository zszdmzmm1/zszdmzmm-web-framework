package com.aue.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/*
* https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html*/
@Component
@Aspect
public class DemoAdvice {
    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.*())")
    private void pt() {
    }


    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.delete()) || execution(void com.aue.dao.impl.UserDaoImpl.update())")
    private void pt2() {
    }

    @Pointcut("execution(void com.aue.dao.impl.UserDaoImpl.update(..))")
    private void pt3() {
    }


    @Before("pt()")
    public void startTimeUsingAtBefore() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);
    }

    @After("pt2()")
    public void endTimeAtAfter() {
        long endTime = System.currentTimeMillis();
        System.out.println("endTime = " + endTime);
    }

    @Around("pt2()")
    public void duringTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println(pjp.getSignature() + ":" + (endTime - startTime));
    }
}
