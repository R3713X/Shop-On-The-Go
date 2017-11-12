package com.shoponthego.shops;

import java.util.List;

import com.shoponthego.offers.IOffer;

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
	IOffer getOffer(String id);

}
