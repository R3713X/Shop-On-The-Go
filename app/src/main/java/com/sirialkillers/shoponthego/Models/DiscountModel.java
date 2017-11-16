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
    int shopId;
    int discountId;
    double percentage;
    String title;
    String description;
    Date expirationDate;

    @Override
    public int getShopId() {

        return shopId;
    }

    @Override
    public int getDiscountId() {

        return discountId;
    }

    @Override
    public double getPercentage()
    {
        return percentage;
    }

    @Override
    public String getTitle()
    {
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
}
