package com.aue.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutowiredService {

    AutowiredDao autowiredDao;


    public AutowiredDao getAutowiredDao() {
        return autowiredDao;
    }

    @Autowired
    public void setAutowiredDao(AutowiredDao autowiredDao) {
        this.autowiredDao = autowiredDao;
    }
}
