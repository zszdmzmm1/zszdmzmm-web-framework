package com.aue;

import com.aue.config.ValueBean;
import com.aue.config.ValueBeanConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueAnnotationTest {
    @Test
    @DisplayName("@Value, @PropertySource 注入默认值")
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ValueBeanConfig.class);
        ValueBean valueBean = ac.getBean(ValueBean.class);
        Assertions.assertEquals("hjf", valueBean.getName());
        Assertions.assertEquals("valueBean", valueBean.getText());
    }
}
