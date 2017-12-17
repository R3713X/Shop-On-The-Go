package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;

/**
 * @author Ioakeim James Theologou
 * @version 14/12/2017
 *
 */
public class ProductModel extends ArrayList{
    private String productName;
    private String productId;
    private int quantityPerUnit;
    private long unitPrice;

    public ProductModel(String productId, String productName){
        this.productId = productId;
        this.productName = productName;
    }

    public ProductModel(String productId){
        this.productId = productId;
        this.productName = "";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
