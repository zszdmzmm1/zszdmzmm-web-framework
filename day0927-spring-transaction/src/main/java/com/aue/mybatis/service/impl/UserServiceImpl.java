package com.aue.mybatis.service.impl;

import com.aue.mybatis.mapper.UserMapper;
import com.aue.mybatis.po.User;
import com.aue.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void saveWithoutTransactional(User user) {
        userMapper.addUser(user);
        int a = 1 / 0;
    }

    @Override
    public void saveWithTransactional(User user) {
        userMapper.addUser(user);
        int a = 1 / 0;
    }

    @Override
    public List<User> selectUsersByName(String name) {
        return userMapper.selectUserByName(name);
    }

    public void truncate() {
        userMapper.truncateTable();
    }
}
