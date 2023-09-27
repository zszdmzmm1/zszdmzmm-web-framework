package com.aue.config;

import com.aue.aop.MathDivide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AopAdviceOrderTest {
    @Test
    @DisplayName("测试Advice的执行顺序，执行成功")
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AdviceConfig.class);
        MathDivide mathDivide = ac.getBean(MathDivide.class);
        mathDivide.div(2, 1);
        String expect = "Before.*" + System.lineSeparator() +
                "AfterReturning.*" + System.lineSeparator() +
                "After.*" + System.lineSeparator();
        Assertions.assertTrue(out.toString().matches(expect));
    }

    @Test
    @DisplayName("测试Advice的执行顺序，报错情况")
    public void test2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AdviceConfig.class);
        MathDivide mathDivide = ac.getBean(MathDivide.class);

        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
                    mathDivide.div(2, 0);
                }
        );

        Assertions.assertEquals("/ by zero", exception.getMessage());
        String expect = "Before.*" + System.lineSeparator() +
                "AfterThrowing.*" + System.lineSeparator() +
                "After.*" + System.lineSeparator();
        Assertions.assertTrue(out.toString().matches(expect));
    }
}
