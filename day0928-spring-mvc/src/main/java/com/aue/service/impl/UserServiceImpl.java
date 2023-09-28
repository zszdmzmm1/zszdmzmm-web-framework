package com.aue.service.impl;

import com.aue.dao.UserDao;
import com.aue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void save() {
        userDao.insert();
        System.out.println("UserServiceImpl.save");
    }
}
