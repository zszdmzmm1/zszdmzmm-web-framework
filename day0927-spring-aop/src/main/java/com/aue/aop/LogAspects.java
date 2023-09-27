package com.aue.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {
    @Pointcut("execution(int com.aue.aop.MathDivide.div(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before" + "---" + joinPoint.getSignature().getName() + ":" + System.currentTimeMillis());
    }

    @After("pt()")
    public void after(JoinPoint joinPoint){
        System.out.println("After" + "---" + joinPoint.getSignature().getName() + ":" + System.currentTimeMillis());
    }

    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("AfterReturning" + "---" + joinPoint.getSignature().getName() + ":" + System.currentTimeMillis());
    }

    @AfterThrowing(value = "pt()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        System.out.println("AfterThrowing" + "---" + joinPoint.getSignature().getName() + ":" + System.currentTimeMillis() + "---" + exception.getMessage());
    }
}
