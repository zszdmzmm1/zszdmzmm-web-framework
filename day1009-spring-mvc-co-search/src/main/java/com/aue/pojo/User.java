package com.aue.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private String role;

    private List<Post> postList;
}
