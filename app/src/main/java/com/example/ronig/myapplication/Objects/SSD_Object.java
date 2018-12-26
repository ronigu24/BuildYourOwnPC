package com.example.ronig.myapplication.Objects;

import com.example.ronig.myapplication.Objects.Product;

public class SSD_Object extends Product {

    public SSD_Object (String name, String price)
    {
        super(name, price);
    }

    public SSD_Object ()
    {
        super();
    }
    public String print(){return "SSD:"+" "+ name +" "+price;}

}
