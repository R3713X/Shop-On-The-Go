package com.sirialkillers.shoponthego.Interfaces;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 12-Nov-17.
 */

public interface IDiscount {
    public String getDiscountTitle();
    public void setDiscountTitle(String title);
    public String getDiscountDescription();
    public void setDiscountDescription(String description);
    public String getDiscountCategories();
    public void setDiscountCategories(String categories);
    public int getDiscountShopId();
    public void setDiscountShopId(int shopId);
    public int getDiscountPercentage();
    public void setDiscountPercentage(int discountValue);
    public Date getDiscountExpirationDate();
    public void setDiscountExpirationDate(Date expirationDate);
}
