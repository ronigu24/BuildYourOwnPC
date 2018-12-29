package com.example.ronig.myapplication.Objects;

public class Order {

    int Id;
    String userName;
    String price;
    String status;

    public Order(int id, String userName, String price, String status) {
        Id = id;
        this.userName = userName;
        this.price = price;
        this.status = status;
    }

    public void setId(int id) {
        Id = id;
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
            this.status ="approved";
    }

    public void canceled(){
        this.status = "Canceled";
    }


    public int getId() {

        return Id;
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
}
