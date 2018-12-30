package com.example.ronig.myapplication.Objects.Products;

public class Case extends Product {

    public Case(String name, String price)
    {
        super(name, price);
    }

    public Case()
    {
        super();
    }
    public String print(){return "Case:"+" "+ name +" "+price;}
}
