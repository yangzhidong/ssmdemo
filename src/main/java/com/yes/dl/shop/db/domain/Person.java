package com.yes.dl.shop.db.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("person")
public class Person implements Serializable {

    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
