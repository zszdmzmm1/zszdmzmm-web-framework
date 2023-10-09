package com.aue.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String email;
    @JsonIgnore
    private String password;
    private String role;

    @JsonIgnore
    private List<Post> postList;
}
