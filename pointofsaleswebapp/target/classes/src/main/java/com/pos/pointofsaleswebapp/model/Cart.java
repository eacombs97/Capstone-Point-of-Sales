package com.pos.pointofsaleswebapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Cart {

    private List<OrderItem> orderItems;

    public Cart() {
        this.orderItems = new ArrayList<>();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
