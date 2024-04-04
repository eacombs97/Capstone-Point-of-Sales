/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.POS;

/**
 *
 * @author kairagaines
 */
import java.util.Date;

public class Promotion {
    private int promotionId;
    private String name;
    private String description;
    private float discountAmount;
    private  Date startDate;
    private Date endDate;


public Promotion(int promotionId, String name, String description, float discountAmount, Date startDate, Date endDate) {

    this.promotionId = promotionId;
    this.name = name;
    this.description = description;
    this.discountAmount= discountAmount;
    this.startDate = startDate;
    this.endDate = endDate;
}

    /**
     * @return the promotionId
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * @param promotionId the promotionId to set
     */
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the discountAmount
     */
    public float getDiscountAmount() {
        return discountAmount;
    }

    /**
     * @param discountAmount the discountAmount to set
     */
    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



}