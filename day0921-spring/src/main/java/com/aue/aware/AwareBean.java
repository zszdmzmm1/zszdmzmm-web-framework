package com.aue.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class AwareBean implements BeanNameAware, ApplicationContextAware, EmbeddedValueResolverAware {
    private String BeanName;
    private StringValueResolver embeddedValueResolver;

    @Override
    public void setBeanName(String name) {
        this.BeanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }

    public String getBeanName() {
        return BeanName;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.embeddedValueResolver= resolver;
    }

    public String getPropertiesValue(String key) {
        if (key.contains("$")) {
            return this.embeddedValueResolver.resolveStringValue(key);
        }
        return key;
    }
}
