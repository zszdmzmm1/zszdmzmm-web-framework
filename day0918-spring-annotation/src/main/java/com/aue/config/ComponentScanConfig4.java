package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "com.aue", includeFilters = {
        @Filter(type = FilterType.REGEX, pattern = ".*Controller.*")
}, useDefaultFilters = false)
public class ComponentScanConfig4 {
}
