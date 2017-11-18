package com.sirialkillers.shoponthego.Interfaces;

import java.util.Date;

/**
 * Created by User on 12-Nov-17.
 */

public interface IDiscount {
    public String getShopId();
    public int getDiscountId();
    public double getPercentage();
    public String getTitle();
    public String getDescription();
    public Date getExpirationDate();
}

