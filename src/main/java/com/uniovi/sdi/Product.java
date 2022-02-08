package com.uniovi.sdi;

public class Product {
    private String name;
    private String image;
    private float price;

    public Product(String name, String image, float price){
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
