package com.aue.autowired2.bean;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyBean {
    String desc = "default";

    public MyBean(String desc) {
        this.desc = desc;
    }

    public MyBean() {
    }
}
