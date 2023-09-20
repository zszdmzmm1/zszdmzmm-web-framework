package com.aue.service.impl;

import com.aue.service.UserService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InitAndDestroyInterfaceUserService implements UserService, InitializingBean, DisposableBean {

    @Override
    public void showLoginService() {
        System.out.println("InitAndDestroyInterfaceUserService.showLoginService");
    }

    @Override
    public void loginService() {
        System.out.println("InitAndDestroyInterfaceUserService.loginService");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitAndDestroyInterfaceUserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitAndDestroyInterfaceUserService.afterPropertiesSet");
    }
}
