package com.aue.mybatis.mapper;

import com.aue.mybatis.po.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    void deleteById(int id);

    void update(User user);

    List<User> selectUserByName(String name);


    void truncateTable();
}
