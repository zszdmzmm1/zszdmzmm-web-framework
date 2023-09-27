package com.aue.aop;

import org.springframework.stereotype.Component;

@Component
public class MathDivide {
    public int div(int dividend, int divisor) {
        return dividend / divisor;
    }
}
