package com.example.ronig.myapplication.Objects;

public class Order {

    String userName;
    String price;
    String status;

    public Order(String userName, String price, String status) {

        this.userName = userName;
        this.price = price;
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;

    }
    public void approved(){
            this.status ="Approved";
    }

    public void canceled(){
        this.status = "Canceled";
    }



    public String getUserName() {
        return userName;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return userName+" "+price+" "+status;
    }
}
