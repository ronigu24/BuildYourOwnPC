package com.example.ronig.myapplication.Objects.Products;

public class SSD extends Product {

    public SSD(String name, String price)
    {
        super(name, price);
    }

    public SSD()
    {
        super();
    }
    public String print(){return "SSD:"+" "+ name +" "+price;}

}
