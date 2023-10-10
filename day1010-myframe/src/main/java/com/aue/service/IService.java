package com.aue.service;


import jakarta.servlet.ServletContext;

public interface IService {
    void onStartup(ServletContext servletContext);
}
