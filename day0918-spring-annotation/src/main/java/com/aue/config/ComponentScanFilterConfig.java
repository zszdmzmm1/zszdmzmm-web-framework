package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "com.aue", includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = {Controller.class})
}, useDefaultFilters = false)
public class ComponentScanFilterConfig {
}
