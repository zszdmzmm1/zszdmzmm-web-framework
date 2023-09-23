package com.aue;

import com.aue.config.ImportBeanDefinitionRegistrarConfig;
import com.aue.config.ImportConfig;
import com.aue.config.ImportResourceConfig;
import com.aue.config.ImportSelectorConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportConfigTest {
    @Test
    @DisplayName("@Import导入的类，bean的名字默认是完整的类名")
    public void importTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportConfig.class);
        Assertions.assertFalse(ac.containsBean("Apple"));
        Assertions.assertTrue(ac.containsBean("com.aue.pojo.Apple"));
    }

    @Test
    @DisplayName("@Import导入一个实现ImportSelector的类")
    public void importSelectorTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportSelectorConfig.class);
        Assertions.assertTrue(ac.containsBean("com.aue.pojo.Apple"));
        Assertions.assertTrue(ac.containsBean("com.aue.pojo.Banana"));
        Assertions.assertFalse(ac.containsBean("com.aue.pojo.Cat"));
    }

    @Test
    @DisplayName("@Import导入一个实现ImportBeanDefinitionRegistrar的类")
    public void importBeanDefinitionRegistrarTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportBeanDefinitionRegistrarConfig.class);
        Assertions.assertTrue(ac.containsBean("Apple"));
        Assertions.assertTrue(ac.containsBean("Kitty"));
        Assertions.assertFalse(ac.containsBean("com.aue.pojo.Apple"));
        Assertions.assertFalse(ac.containsBean("com.aue.pojo.Cat"));
        Assertions.assertFalse(ac.containsBean("com.aue.pojo.Dog"));
    }

    @Test
    @DisplayName("@ImportResource导入一个配置文件beans.xml")
    public void importResourceTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportResourceConfig.class);
        Assertions.assertTrue(ac.containsBean("puppy"));
        Assertions.assertTrue(ac.containsBean("kitten"));
        Assertions.assertFalse(ac.containsBean("pony"));
        Assertions.assertFalse(ac.containsBean("donkey"));
    }
}
