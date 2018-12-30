package com.example.ronig.myapplication.Objects;

import com.example.ronig.myapplication.Objects.Products.Computer;

public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    public Computer my_pc;

    public User(String id, String name, String password, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.my_pc=new Computer();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void build_pc(Computer my_pc){this.my_pc=my_pc;}
}
