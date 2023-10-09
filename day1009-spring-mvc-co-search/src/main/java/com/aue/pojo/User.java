package com.aue.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private String role;
}
