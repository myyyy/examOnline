package com.augmentum.examonline.model;

public class User {
    private int id;
    private String name;
    private String password;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int idDB) {
        this.id = idDB;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + name + ", userPassword=" + password + "]";
    }
}
