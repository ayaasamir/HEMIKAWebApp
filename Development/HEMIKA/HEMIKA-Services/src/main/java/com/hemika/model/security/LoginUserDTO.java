package com.hemika.model.security;

import java.io.Serializable;

public class LoginUserDTO implements Serializable {

    private String username;
    private String password;

    public LoginUserDTO() {
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

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

