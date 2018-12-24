package com.example.ronig.myapplication.Objects;

public class Product {

    String name;
    int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    Product(){
        this.name = "";
        this.price = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

}
