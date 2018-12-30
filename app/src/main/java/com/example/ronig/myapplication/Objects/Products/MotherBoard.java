package com.example.ronig.myapplication.Objects.Products;

public class MotherBoard extends Product {

    public MotherBoard(String name, String price)
    {
        super(name, price);
    }
    public MotherBoard()
    {
        super();
    }
    public String print(){return "MotherBoard:"+" "+ name +" "+price;}

}
