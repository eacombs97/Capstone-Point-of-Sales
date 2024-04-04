/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kairagaines
 */

import java.util.Date;

public class Discount {

    private int discountID;
    private int discountCode;
    private float discountAmount;
    private  Date startDate;
    private Date endDate;
    

public Discount(int discountID,int discountCode, float discountAmount,Date startDate, Date endDate) {
           this.discountID = discountID;
           this.discountCode = discountCode;
           this.discountAmount= discountAmount;
           this.startDate = startDate;
           this.endDate = endDate;
}
//add promotion to item method
public void addPromotion (int discountID, float discountAmount){
    // for specific discount ID retreive discount amount from database
        
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
     * @return the discountCode
     */
    public int getDiscountCode() {
        return discountCode;
    }

    /**
     * @param discountCode the discountCode to set
     */
    public void setDiscountCode(int discountCode) {
        this.discountCode = discountCode;
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
   