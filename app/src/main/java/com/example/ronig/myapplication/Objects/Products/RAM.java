package com.example.ronig.myapplication.Objects.Products;

public class RAM extends Product {

    public RAM(String name, String price)
    {
        super(name, price);
    }
    public RAM()
    {
        super();
    }
    public String print(){return "RAM:"+" "+ name +" "+price;}
}
