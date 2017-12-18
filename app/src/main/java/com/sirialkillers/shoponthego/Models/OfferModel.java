package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 14/12/2017
 *
 */
public class OfferModel extends ArrayList{
    private String shopId;
    private String offerId;
    private String title;
    private String description;
    private Date expirationDate;
    private List<ProductModel> products;


    public OfferModel(String shopId, String offerId, String title, String description){
        this.shopId = shopId;
        this.offerId = offerId;
        this.title = title;
        this.description = description;

    }

    public OfferModel(String shopId){
        this.shopId = shopId;
        this.offerId = "";
        this.title="";
        this.description = "";
    }

    public String getShopId() {

        return shopId;
    }

    public void setShopId(String shopId) {

        this.shopId = shopId;
    }

    public String getOfferId() {

        return offerId;
    }

    public void setOfferId(String offerId) {

        this.offerId = offerId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getExpirationDate() {

        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {

        this.expirationDate = expirationDate;
    }

    public List<ProductModel> getProducts() {

        return products;
    }

    public void setProducts(List<ProductModel> products) {

        this.products = products;
    }
}
