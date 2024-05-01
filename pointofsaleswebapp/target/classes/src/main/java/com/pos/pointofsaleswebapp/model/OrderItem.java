package com.pos.pointofsaleswebapp.model;

import org.springframework.stereotype.Component;

@Component
public class OrderItem {
    private Product product;
    private int quantity;
    
    public OrderItem(){
        
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters for product and quantity
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


