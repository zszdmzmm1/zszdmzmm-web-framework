package com.aue;

import com.aue.aware.AwareBean;
import com.aue.aware.AwareConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareBeanTest {
    @Test
    @DisplayName("aware 系列接口的示例")
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareBean bean =(AwareBean) ac.getBean("getAwareBean");
        Assertions.assertEquals(System.getProperty("os.name"), bean.getPropertiesValue("${os.name}"));
        Assertions.assertEquals(bean.getBeanName(), "getAwareBean");
    }
}
