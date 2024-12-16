package com.example.myplace;

public class User {
    private int id;
    private String username;
    private String pwd;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public User (int id, String username, String pwd, String first_name, String last_name,
                 String email, String phone) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }
}
