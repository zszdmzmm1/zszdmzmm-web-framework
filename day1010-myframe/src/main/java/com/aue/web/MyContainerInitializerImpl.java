package com.aue.web;

import com.aue.service.IService;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@HandlesTypes(IService.class)
public class MyContainerInitializerImpl implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
        List<IService> initializers = new ArrayList<>();
        for (Class<?> waiClass : webAppInitializerClasses) {
            if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers())) {
                try {
                    initializers.add((IService)
                            ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                } catch (Throwable ex) {
                    throw new ServletException();
                }
            }
        }
        for (IService initializer : initializers) {
            initializer.onStartup(servletContext);
        }
    }
}
