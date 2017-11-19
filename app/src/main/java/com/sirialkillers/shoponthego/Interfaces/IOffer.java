package com.sirialkillers.shoponthego.Interfaces;

import java.util.Date;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 16/11/2017
 *
 */
public interface IOffer {
    public String getShopId();
    public String getOfferId();
    public List<IProduct> getProducts();
    public String getTitle();
    public String getDescription();
    public Date getExpirationDate();
}
