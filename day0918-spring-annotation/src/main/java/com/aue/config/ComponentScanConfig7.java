package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@ComponentScan(basePackages = "com.aue",  excludeFilters = @ComponentScan.Filter(Controller.class), useDefaultFilters = false)
public class ComponentScanConfig7 {
}
