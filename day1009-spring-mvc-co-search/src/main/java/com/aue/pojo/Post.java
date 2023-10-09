package com.aue.pojo;

import lombok.Data;

@Data
public class Post {
    private int id;
    private int userId;
    private String title;
    private String cover;
    private String publishTime;
    private String lastUpdateTime;
    private String content;
    private int view;
    private String description;
    private int status;
}
