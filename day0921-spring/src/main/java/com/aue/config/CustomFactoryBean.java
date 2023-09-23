package com.aue.config;

import com.aue.pojo.Apple;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CustomFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Apple();
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }

}
