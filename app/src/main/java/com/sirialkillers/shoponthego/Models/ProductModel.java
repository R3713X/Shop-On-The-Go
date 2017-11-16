package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.IProduct;

/**
 * @author Ioakeim James Theologou
 * @version 16/11/2017
 * TODO: Create a test class for this model.
 *
 */
public class ProductModel implements IProduct {
    String productName;
    int productId;
    int quantityPerUnit;
    long unitPrice;

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
