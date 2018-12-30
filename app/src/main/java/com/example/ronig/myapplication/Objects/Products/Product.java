package com.example.ronig.myapplication.Objects.Products;

public class Product {

   String name;
   String price;

    public Product(String name, String price){
        this.name = name;
        this.price = price;
    }

    public Product(){
        this.name = "";
        this.price = "";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getPrice(){
        return this.price;
    }


}
