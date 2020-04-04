package com.fslq.domain;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private String username;
    private String password;
    private Float money;

    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money=money;
    }
}
