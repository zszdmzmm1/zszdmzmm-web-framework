package com.aue.mybatis.service;

import com.aue.mybatis.po.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void saveWithoutTransactional(User user);

    @Transactional
    void saveWithTransactional(User user);

    List<User> selectUsersByName(String name);

    void truncate();

}
