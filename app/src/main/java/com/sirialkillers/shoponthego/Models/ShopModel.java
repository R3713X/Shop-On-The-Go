package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Interfaces.ICategory;
import com.sirialkillers.shoponthego.Interfaces.IDiscount;
import com.sirialkillers.shoponthego.Interfaces.IOffer;
import com.sirialkillers.shoponthego.Interfaces.IProduct;
import com.sirialkillers.shoponthego.Interfaces.IShop;
import com.sirialkillers.shoponthego.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 14/10/2017
 * TODO: Create a test class for this model.
 *
 */

public class ShopModel extends ArrayList implements IShop {
    private String id;
    private String name;
    private Position position;
    private List<IDiscount> discounts;
    private List<IOffer> offers;
    private List<IProduct> products;
    private List <ICategory> categories;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Position getPosition() {

        return position;
    }

    public void setPosition(Position position) {

        this.position = position;
    }

    @Override
    public List<IOffer> getOffers() {

        return null;
    }

    @Override
    public IOffer getOffer(String offerId) {

        return null;
    }

    @Override
    public List<IProduct> getAllProducts() {

        return null;
    }

    @Override
    public IProduct getProduct(String productId) {

        return null;
    }

    @Override
    public List<IDiscount> getAllDiscounts() {

        return null;
    }

    @Override
    public IDiscount getDiscount(String discountId) {

        return null;
    }
}
