package com.example.food_app.model;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private String name;
    private String pic;
    private String des;
    private Double fee;
    private int numberInCart;

    public ProductModel(String title, String pic, String des, Double fee) {
        this.name = title;
        this.pic = pic;
        this.des = des;
        this.fee = fee;
    }

    public ProductModel(String title, String pic, String des, Double fee, int numberInCart) {
        this.name = title;
        this.pic = pic;
        this.des = des;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
