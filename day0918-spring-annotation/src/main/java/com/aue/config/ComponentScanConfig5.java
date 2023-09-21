package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "com.aue", includeFilters = {
        @Filter(type = FilterType.CUSTOM, classes = CustomTypeFilter.class)
}, useDefaultFilters = false)
public class ComponentScanConfig5 {
}
