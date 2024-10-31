package org.chousik.weblab2.bean;

public class User {
    private String name;

    // Публичный конструктор по умолчанию
    public User() {
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}