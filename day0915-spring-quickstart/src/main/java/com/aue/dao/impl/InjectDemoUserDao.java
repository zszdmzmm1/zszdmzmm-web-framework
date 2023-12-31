package com.aue.dao.impl;

import com.aue.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class InjectDemoUserDao implements UserDao {
    private int straightValue;

    private int[] array;

    public int getStraightValue() {
        return straightValue;
    }

    public void setStraightValue(int straightValue) {
        this.straightValue = straightValue;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private List<String> list;

    private Set<String> set;

    private Map<String,String> map;

    private Properties properties;

    @Override
    public void showLogin() {
        System.out.println("InjectDemoUserDao.showLogin");
    }

    @Override
    public void login() {
        System.out.println("InjectDemoUserDao.login");
    }
}
