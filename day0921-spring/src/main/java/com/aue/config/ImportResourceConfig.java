package com.aue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:beans.xml")
public class ImportResourceConfig {
}
