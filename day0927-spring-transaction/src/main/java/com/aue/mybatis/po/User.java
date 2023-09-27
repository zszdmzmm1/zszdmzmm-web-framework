package com.aue.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int balance;

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
