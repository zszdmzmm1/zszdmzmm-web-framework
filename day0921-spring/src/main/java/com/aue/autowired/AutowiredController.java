package com.aue.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AutowiredController {
    @Resource
    AutowiredService autowiredService;

    AutoWiredUtil2 autoWiredUtil2;

    public AutoWiredUtil2 getAutoWiredUtil2() {
        return autoWiredUtil2;
    }

    @Autowired(required = false)
    public void setAutoWiredUtil2(AutoWiredUtil2 autoWiredUtil2) {
        this.autoWiredUtil2 = autoWiredUtil2;
    }

    public AutowiredService getAutowiredService() {
        return autowiredService;
    }


    public void setAutowiredService(AutowiredService autowiredService) {
        this.autowiredService = autowiredService;
    }
}
