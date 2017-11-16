package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.IOffer;
import com.sirialkillers.shoponthego.Interfaces.IProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 * TODO: Create a test class for this model.
 *
 */
public class OfferModel extends ArrayList implements IOffer{
    private String shopId;
    private String offerId;
    private String title;
    private String description;
    private Date expirationDate;
    private List<IProduct> products;


    @Override
    public String getShopId() {

        return shopId;
    }

    @Override
    public String getOfferId() {

        return offerId;
    }

    @Override
    public List<IProduct> getProducts() {

        return products;
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
