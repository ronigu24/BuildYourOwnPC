package com.example.ronig.myapplication.Objects;

public class CPU_Object extends Product {

    public CPU_Object (String name, String price)
    {
        super(name, price);
    }
    public CPU_Object ()

    {
        super();
    }
    public String print(){return "CPU:"+" "+ name +" "+price;}
}
