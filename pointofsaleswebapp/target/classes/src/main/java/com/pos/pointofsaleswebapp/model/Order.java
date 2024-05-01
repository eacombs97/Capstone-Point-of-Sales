package com.pos.pointofsaleswebapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private String orderId;
    private String customer;
    private List<OrderItem> cart;
    private Date orderDate;
    private double totalPrice;
    private String confirmationNumber;

    public Order() {
        // Default constructor for Spring dependency injection
        this.orderId = generateOrderId();
        this.orderDate = new Date();
    }

   public Order(String customer, String orderID, List<OrderItem> cart, double totalPrice) {
        this.orderId = generateOrderId();
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.orderDate = new Date();
        this.customer= customer;
        //this.confirmationNumber = confirmationNumber;
   }
    public String getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer.getCustomerId();
    }

    public List<OrderItem> getCart() {
        return cart;
    }

    public void setCart(List<OrderItem> cart) {
        this.cart= cart;
    }
    public Date getDate(){
        return orderDate;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    private String generateOrderId() {
        // Logic to generate a unique order ID (e.g., using UUID)
        // For simplicity, let's assume it's just a concatenation of customer ID and current timestamp :)
        return customer + "-" + System.currentTimeMillis();
    }
    public String getOrderId() {
        return orderId;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }
    
    public void setConfirmationNumber (String confirmationNumber){
        this.confirmationNumber = confirmationNumber;
    } 
}

