package com.aue.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:valueBean.properties")
public class ValueBean {
    @Value("hjf")
    private String name;
    @Value("${text}")
    private String text;
    @Value("${description}")
    private String description;
    @Value("#{1 + 1}")
    private Integer num;

}
