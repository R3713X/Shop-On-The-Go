package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.IDiscount;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Ioakeim James Theologou
 * @version 15/11/2017
 * TODO: Create a test class for this model.
 *
 */
public class DiscountModel extends ArrayList implements IDiscount{
    private String shopId;
    private String discountId;
    private double percentage;
    private String title;
    private String description;
    private Date expirationDate;

    public DiscountModel(String shopId, String discountId, double percentage,
                         String title, String description){
        this.shopId = shopId;
        this.discountId = discountId;
        this.percentage = percentage;
        this.title = title;
        this.description = description;
    }

    @Override
    public String getShopId() {

        return shopId;
    }

    @Override
    public String getDiscountId() {

        return discountId;
    }

    @Override
    public double getPercentage() {

        return percentage;
    }

    @Override
    public String getTitle() {

        return title;
    }

    @Override
    public String getDescription() {

        return description;
    }

    @Override
    public Date getExpirationDate() {

        return expirationDate;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
