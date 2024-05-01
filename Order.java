/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POS;

/**
 *
 * @author kairagaines
 */
public class Order {
    private int orderID;
    private int userID;
    private int discountID;
    private int shippingDetailsID;
    private int taxID;
    private int paymentID;
    private int guestID;
    private int totalQuantityID;
    private float total;
    
    public Order (int orderID, int userID, int discountID, int shippingDetailsID,
            int taxID, int paymentID, int totalQuantityID, float total){
        
        this.orderID = orderID;
        this.userID = userID;
        this.discountID = discountID;
        this.shippingDetailsID = shippingDetailsID;
        this.taxID = taxID;
        this.paymentID = paymentID;
        this.totalQuantityID = totalQuantityID;
        this.total = total;
    }
    public void setOrderID(int orderID){
        this.orderID = orderID; 
    }
    public int getOrderID(){
        return orderID;
    }
      public void userID(int userID){
        this.userID = userID; 
    }
    public int userID(){
        return userID;
    }

    /**
     * @return the discountID
     */
    public int getDiscountID() {
        return discountID;
    }

    /**
     * @param discountID the discountID to set
     */
    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    /**
     * @return the shippingDetailsID
     */
    public int getShippingDetailsID() {
        return shippingDetailsID;
    }

    /**
     * @param shippingDetailsID the shippingDetailsID to set
     */
    public void setShippingDetailsID(int shippingDetailsID) {
        this.shippingDetailsID = shippingDetailsID;
    }

    /**
     * @return the taxID
     */
    public int getTaxID() {
        return taxID;
    }

    /**
     * @param taxID the taxID to set
     */
    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    /**
     * @return the paymentID
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * @param paymentID the paymentID to set
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }



    /**
     * @return the totalQuantityID
     */
    public int getTotalQuantityID() {
        return totalQuantityID;
    }

    /**
     * @param totalQuantityID the totalQuantityID to set
     */
    public void setTotalQuantityID(int totalQuantityID) {
        this.totalQuantityID = totalQuantityID;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
}
