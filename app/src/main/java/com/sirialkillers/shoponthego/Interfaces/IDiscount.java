package com.sirialkillers.shoponthego.Interfaces;

import java.util.Date;

/**

 * @author Ioakeim James Theologou
 * @version 16/11/2017
 *
 */
public interface IDiscount {
    public String getShopId();
    public String getDiscountId();
    public double getPercentage();
    public String getTitle();
    public String getDescription();
    public Date getExpirationDate();
}

