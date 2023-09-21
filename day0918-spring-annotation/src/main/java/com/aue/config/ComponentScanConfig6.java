package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@ComponentScan(basePackages = "com.aue", includeFilters = {
        @Filter(Controller.class), @Filter(Service.class), @Filter(Repository.class)
}, excludeFilters = @Filter(Controller.class), useDefaultFilters = false)
public class ComponentScanConfig6 {
}
