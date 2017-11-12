package com.shoponthego.shops;

import java.util.List;

import com.shoponthego.offers.IOffer;
import com.shoponthego.products.IProduct;
import com.shoponthego.shops.discounts.IDiscount;

public interface IShop {

	String getId();
	String getName();
	
	/*
	String getEmail();
	String getPhoneNumber();
	String getCountry();
	String getRegion();
	String getCity();
	String getAddress();
	String getPostcode();
	*/
	List<IOffer> getOffers();
	IOffer getOffer(String offerId);
	List<IProduct> getAllProducts();
	IProduct getProduct(String productId);
	List<IDiscount> getAllDiscounts();
	IDiscount getDiscount(String discountId);

}
