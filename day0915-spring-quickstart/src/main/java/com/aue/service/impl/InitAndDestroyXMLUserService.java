package com.aue.service.impl;

import com.aue.service.UserService;

public class InitAndDestroyXMLUserService implements UserService {
    public void init() {
        System.out.println("InitAndDestroyXMLUserService.init");
    }

    public void destroy() {
        System.out.println("InitAndDestroyXMLUserService.destroy");
    }

    @Override
    public void showLoginService() {
        System.out.println("InitAndDestroyXMLUserService.showLoginService");
    }

    @Override
    public void loginService() {
        System.out.println("InitAndDestroyXMLUserService.loginService");
    }
}
