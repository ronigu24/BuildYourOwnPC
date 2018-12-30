package com.example.ronig.myapplication.Objects.Products;

public class CPU extends Product {

    public CPU(String name, String price)
    {
        super(name, price);
    }
    public CPU()

    {
        super();
    }
    public String print(){return "CPU:"+" "+ name +" "+price;}
}
