package com.aue.dao.impl;


import com.aue.dao.UserDao;

public class NopUserDao implements UserDao {
    @Override
    public void showLogin() {
        System.out.println("NopUserDao.showLogin");
    }

    @Override
    public void login() {
        System.out.println("NopUserDao.login");
    }
}
