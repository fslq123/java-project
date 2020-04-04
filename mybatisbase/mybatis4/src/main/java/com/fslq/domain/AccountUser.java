package com.fslq.domain;

import java.io.Serializable;

public class AccountUser implements Serializable {
    private Integer id;
    private String username;
    private String sex;
    private String address;

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
