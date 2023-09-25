package com.aue;

import com.aue.autowired2.MultipleBeanConfig;
import com.aue.autowired2.PrimaryConfig;
import com.aue.autowired2.bean.MyController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredConfig2Test {
    @Test
    @DisplayName("两个Bean同名，会被覆写")
    public void multipleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MultipleBeanConfig.class);
        MyController myController =(MyController) ac.getBean("myController");
        Assertions.assertEquals("other", myController.getMyBean().getDesc());
    }
    @Test
    @DisplayName("@Autowired 找类型相同，多个时找id")
    public void multipleTest1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrimaryConfig.class);
        MyController myController =(MyController) ac.getBean("myController");
        Assertions.assertEquals("default", myController.getMyBean().getDesc());
    }


}
