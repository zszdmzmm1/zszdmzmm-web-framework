package com.aue.web;

import com.aue.filter.DispatcherFilter;
import com.aue.listener.DispatcherListener;
import com.aue.service.IService;
import com.aue.servlet.DispatcherServlet;
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
        servletContext.addServlet("dispatcherServlet", DispatcherServlet.class).addMapping("/hello");
        servletContext.addFilter("dispatcherFilter", DispatcherFilter.class).addMappingForUrlPatterns(null, false, "/hello");
        servletContext.addListener(DispatcherListener.class);
    }
}
