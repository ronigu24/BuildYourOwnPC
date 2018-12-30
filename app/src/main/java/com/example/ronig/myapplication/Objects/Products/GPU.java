package com.example.ronig.myapplication.Objects.Products;

public class GPU extends Product {

    public GPU(String name, String price)
    {
        super(name, price);
    }
    public GPU()
    {
        super();
    }
    public String print(){return "GPU:"+" "+ name +" "+price;}
}