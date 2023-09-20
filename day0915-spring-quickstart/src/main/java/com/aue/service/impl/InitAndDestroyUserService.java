package com.aue.service.impl;

import com.aue.service.UserService;

public class InitAndDestroyUserService implements UserService {
    public void init() {
        System.out.println("InitAndDestroyUserService.init");
    }

    public void destroy() {
        System.out.println("InitAndDestroyUserService.destroy");
    }

    @Override
    public void showLoginService() {
        System.out.println("InitAndDestroyUserService.showLoginService");
    }

    @Override
    public void loginService() {
        System.out.println("InitAndDestroyUserService.loginService");
    }
}
