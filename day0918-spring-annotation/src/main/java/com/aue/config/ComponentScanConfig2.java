package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@ComponentScan(basePackages = "com.aue", useDefaultFilters = false, includeFilters = {
        @Filter(Controller.class), @Filter(Service.class)
})
public class ComponentScanConfig2 {
}
