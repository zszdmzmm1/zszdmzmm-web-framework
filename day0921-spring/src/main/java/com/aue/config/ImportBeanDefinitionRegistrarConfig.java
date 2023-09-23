package com.aue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomImportBeanDefinitionRegistrar.class)
public class ImportBeanDefinitionRegistrarConfig {

}
