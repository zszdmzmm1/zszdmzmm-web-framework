package com.aue.service.impl;


import com.aue.service.UserService;

public class NopUserService implements UserService {
    @Override
    public void showLoginService() {
        System.out.println("nop---showLoginService...");
    }

    @Override
    public void loginService() {
        System.out.println("nop---loginService...");
    }
}
