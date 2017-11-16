package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.IProduct;

import java.util.ArrayList;

/**
 * @author Ioakeim James Theologou
 * @version 16/11/2017
 * TODO: Create a test class for this model.
 *
 */
public class ProductModel extends ArrayList implements IProduct {
    private String productName;
    private int productId;
    private int quantityPerUnit;
    private long unitPrice;

    @Override
    public String getProductName() {

        return productName;
    }

    @Override
    public int getProductId() {

        return productId;
    }

    @Override
    public int getQuantityPerUnit() {

        return quantityPerUnit;
    }

    @Override
    public long getUnitPrice() {

        return unitPrice;
    }
}
