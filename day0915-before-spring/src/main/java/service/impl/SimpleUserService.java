package service.impl;

import dao.UserDao;
import service.UserService;

public class SimpleUserService implements UserService{
    UserDao userDao;

    public SimpleUserService() {
        System.out.println("SimpleUserService.SimpleUserService");
    }

    public SimpleUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void showLoginService() {
        userDao.showLogin();
        System.out.println("showLoginService...");
    }

    @Override
    public void loginService() {
        userDao.login();
        System.out.println("loginService...");
    }
}
