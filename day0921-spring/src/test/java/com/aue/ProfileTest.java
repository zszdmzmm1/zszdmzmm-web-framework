package com.aue;

import com.aue.profile.ProfileConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileTest {
    @Test
    @DisplayName("@Profile('test')")
    public void test() {
        System.setProperty("spring.profiles.active", "test");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileConfig.class);
        Assertions.assertNotNull(ac.getBean("getBeanOne"));
        Assertions.assertNotNull(ac.getBean("getBeanTwo"));
        Assertions.assertFalse(ac.containsBean("getBeanThree"));
    }

    @Test
    @DisplayName("@Profile('dev')")
    public void test1() {
        System.setProperty("spring.profiles.active", "dev");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileConfig.class);
        Assertions.assertNotNull(ac.getBean("getBeanOne"));
        Assertions.assertFalse(ac.containsBean("getBeanTwo"));
        Assertions.assertFalse(ac.containsBean("getBeanThree"));
    }

    @Test
    @DisplayName("@Profile('prod')")
    public void test2() {
        System.setProperty("spring.profiles.active", "prod");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileConfig.class);
        Assertions.assertFalse(ac.containsBean("getBeanOne"));
        Assertions.assertFalse(ac.containsBean("getBeanTwo"));
        Assertions.assertNotNull(ac.getBean("getBeanThree"));
    }
}
