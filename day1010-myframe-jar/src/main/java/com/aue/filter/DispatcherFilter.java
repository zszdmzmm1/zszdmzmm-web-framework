package com.aue.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

public class DispatcherFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DispatcherFilter.doFilter");
        chain.doFilter(request, response);
    }
}