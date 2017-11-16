package com.shoponthego.shops;

import java.util.List;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.IOffer;
import com.shoponthego.products.IProduct;
import com.shoponthego.shops.discounts.IDiscount;

public interface IShop {

	public String getId();
	public String getName();
	public Location getLocation();
	
	/*
	public String getEmail();
	public String getPhoneNumber();
	public String getCountry();
	public String getRegion();
	public String getCity();
	public String getAddress();
	public 	String getPostcode();
	*/
	public List<IOffer> getOffers();
	public IOffer getOffer(String offerId);
	public List<IProduct> getAllProducts();
	public IProduct getProduct(String productId);
	public List<IDiscount> getDiscounts();
	public IDiscount getDiscount(String discountId);

}
