package com.example.demo;

public class Person {
    private Integer id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Person:{"+"id = "+id+",name = '"+name+'\''+",password = '"+password+'\''+'}';
    }
}
