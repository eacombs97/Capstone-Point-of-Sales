/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POS;
import java.util.ArrayList;

/**
 *
 * @author kairagaines
 */
public class Cart {
 //switch this to products rather than orderitem
 private ArrayList<OrderItem> orderItem;

 public void addToCart(OrderItem item){
     this.orderItem.add(item);
 }
 
 public void removeFromCart(OrderItem item){
     this.orderItem.remove(item);
 }
    
 
 
 /**
     * @return the orderItem
     */
    public ArrayList<OrderItem> getOrderItem() {
        return orderItem;
    }

    /**
     * @param orderItem the orderItem to set
     */
    public void setOrderItem(ArrayList<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
 
    
    
}
