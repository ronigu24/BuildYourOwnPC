package com.example.ronig.myapplication.Objects;

public class Case_Object extends Product {

    public Case_Object (String name, String price)
    {
        super(name, price);
    }

    public Case_Object ()
    {
        super();
    }
    public String print(){return "Case:"+" "+ name +" "+price;}
}
