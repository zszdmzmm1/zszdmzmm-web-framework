package com.aue;


import com.aue.autowired.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredConfigTest {

    @Test
    @DisplayName("@Resource, @Inject, @Autowired")
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        Assertions.assertTrue(ac.containsBean("autowiredController"));
        AutowiredController autowiredController = ac.getBean(AutowiredController.class);
        Assertions.assertNotNull(autowiredController.getAutowiredService());
        AutowiredService service = autowiredController.getAutowiredService();
        Assertions.assertNotNull(service.getAutowiredDao());
        AutowiredDao dao = service.getAutowiredDao();
        Assertions.assertNotNull(dao.getAutowiredUtil());
    }


    @Test
    @DisplayName("@Autowired(required = false)")
    public void test2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        AutowiredController autowiredController = ac.getBean(AutowiredController.class);
        Assertions.assertNull(autowiredController.getAutoWiredUtil2());
    }
}
