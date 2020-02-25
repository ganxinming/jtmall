package com.jtmall.entity;

import java.io.Serializable;

/**
 * @Author Badribbit
 * @create 2020/1/9 9:45
 * @Define
 * @Tutorials
 * @Opinion
 */
public class User implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int id;

    private String username;

    private String password;


}
