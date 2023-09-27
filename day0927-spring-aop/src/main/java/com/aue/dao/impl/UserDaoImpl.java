package com.aue.dao.impl;

import com.aue.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void creat() {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime = " + startTime);
        System.out.println("UserDaoImpl.creat");
    }

    @Override
    public void retrieve() {
        System.out.println("UserDaoImpl.retrieve");
    }

    @Override
    public void update() {
        System.out.println("UserDaoImpl.update");
    }

    @Override
    public void delete() {
        System.out.println("UserDaoImpl.delete");
    }
}
