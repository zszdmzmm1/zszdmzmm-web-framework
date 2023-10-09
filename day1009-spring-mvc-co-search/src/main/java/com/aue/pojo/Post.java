package com.aue.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Post {
    private int id;
    private int userId;
    private String title;
    private String cover;
    private String publishTime;
    private String lastUpdateTime;
    @JsonIgnore
    private String content;
    private int view;
    private String description;
    private int status;

    private User user;
}
