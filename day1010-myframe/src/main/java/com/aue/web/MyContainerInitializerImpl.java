package com.aue.web;

import com.aue.service.IService;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(IService.class)
public class MyContainerInitializerImpl implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> iServices, ServletContext servletContext) {
        for (Class<?> iService : iServices) {
            System.out.println(iService);
        }
    }
}
