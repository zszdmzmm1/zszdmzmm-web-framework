package dao.impl;

import dao.UserDao;

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
