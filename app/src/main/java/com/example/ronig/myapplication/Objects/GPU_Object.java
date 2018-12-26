package com.example.ronig.myapplication.Objects;

import com.example.ronig.myapplication.Objects.Product;

public class GPU_Object  extends Product {

    public GPU_Object (String name, String price)
    {
        super(name, price);
    }
    public GPU_Object ()
    {
        super();
    }
    public String print(){return "GPU:"+" "+ name +" "+price;}
}