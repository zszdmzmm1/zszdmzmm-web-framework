package com.aue;

import com.aue.autowired2.MultipleBeanConfig;
import com.aue.autowired2.PrimaryConfig;
import com.aue.autowired2.PrimaryConfig1;
import com.aue.autowired2.QualifierConfig;
import com.aue.autowired2.bean.MyController;
import com.aue.autowired2.bean.QualifierController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredConfig2Test {
    @Test
    @Disabled
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

    @Test
    @DisplayName("@Autowired 优先找带@Primary")
    public void multipleTest2(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrimaryConfig1.class);
        MyController myController =(MyController) ac.getBean("myController");
        Assertions.assertEquals("other", myController.getMyBean().getDesc());
    }

    @Test
    @DisplayName("@Autowired @Qualifier 指定注入的bean的名字")
    public void multipleTest3(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(QualifierConfig.class);
        QualifierController controller =(QualifierController) ac.getBean("qualifierController");
        Assertions.assertEquals("other", controller.getMyBean().getDesc());
    }

}
