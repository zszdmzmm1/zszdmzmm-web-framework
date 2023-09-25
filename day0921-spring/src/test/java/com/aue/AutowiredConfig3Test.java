package com.aue;

import com.aue.autowired3.Boss;
import com.aue.autowired3.OtherPositionAutowiredConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredConfig3Test {
    @Test
    @DisplayName("@Autowired 写在不同位置")
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(OtherPositionAutowiredConfig.class);
        Boss boss = (Boss) ac.getBean("getBoss");
        Assertions.assertNotNull(boss.getAssistant());
        Assertions.assertNotNull(boss.getCar());

        //@autowired写在set方法的参数旁边，set方法未被调用，无法注入
        Assertions.assertNull(boss.getPlane());
    }
}
