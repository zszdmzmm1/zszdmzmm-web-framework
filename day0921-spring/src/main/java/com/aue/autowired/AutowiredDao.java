package com.aue.autowired;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class AutowiredDao {
    AutowiredUtil autowiredUtil;

    public AutowiredUtil getAutowiredUtil() {
        return autowiredUtil;
    }

    @Inject
    public void setAutowiredUtil(AutowiredUtil autowiredUtil) {
        this.autowiredUtil = autowiredUtil;
    }
}
