package com.pos.pointofsaleswebapp.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Component;

@Component
public class Product {

    private Long id;

    private String name;

    private double price;
    
    @Column("product_image")
    private String image_url;

    public Product(Long id, String name, double price, String image_url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image_url = image_url;
    }

    public Product() {
        //TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getImageUrl(){
        return image_url;
    }
    public void setImageUrl(String image_url){
        this.image_url = image_url;
    }
}
