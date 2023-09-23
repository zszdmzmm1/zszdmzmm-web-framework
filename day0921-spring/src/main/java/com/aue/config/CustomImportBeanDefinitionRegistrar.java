package com.aue.config;

import com.aue.pojo.Apple;
import com.aue.pojo.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("Apple", new RootBeanDefinition(Apple.class));
        registry.registerBeanDefinition("Kitty", new RootBeanDefinition(Cat.class));
    }
}
