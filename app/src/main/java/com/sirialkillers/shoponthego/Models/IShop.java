package com.sirialkillers.shoponthego.Models;

import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 14/11/2017
 *
 */
public interface IShop {
    List<IOffer> getOffers();
    IOffer getOffer(String offerId);
    List<IProduct> getAllProducts();
    IProduct getProduct(String productId);
    List<IDiscount> getAllDiscounts();
    IDiscount getDiscount(String discountId);
}
