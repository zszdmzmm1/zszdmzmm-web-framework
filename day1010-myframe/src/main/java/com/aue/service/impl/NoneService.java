package com.aue.service.impl;

import com.aue.service.IService;
import jakarta.servlet.ServletContext;

public class NoneService implements IService {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("NoneService.onStartup");
    }
}
