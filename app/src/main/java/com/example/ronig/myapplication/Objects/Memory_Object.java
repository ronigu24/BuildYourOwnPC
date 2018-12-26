package com.example.ronig.myapplication.Objects;

public class Memory_Object extends Product {

    public Memory_Object (String name, String price)
    {
        super(name, price);
    }
    public Memory_Object ()
    {
        super();
    }
    public String print(){return "RAM:"+" "+ name +" "+price;}
}
