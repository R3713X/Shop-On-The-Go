package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.List;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.Offer;
import com.shoponthego.products.Product;
import com.shoponthego.shops.categories.ICategory;
import com.shoponthego.shops.discounts.Discount;
import com.shoponthego.shops.discounts.IDiscount;
public class Shop {

	private String id;
	private String name;
	
	private Location location;
	
	/*
	private String email;
	private String phone;
	private String country;
	private String region;
	private String city;
	private String address;
	private String postcode;
	*/
	
	private List<Product> products;
 	private List<Offer> offers;
 	private List<IDiscount> discounts;
	private List<ICategory> categories;
	
	
	public Shop() {
		
	}
	
	public Shop(String givenId, String givenName, Location shopLocation) {
		discounts = new ArrayList<>();
		products = new ArrayList<>();
		offers = new ArrayList<>();
		categories = new ArrayList<>();
		id = givenId;
		name = givenName;
		location = shopLocation;
		
	}
	
	public List<ICategory> getCategories() {
		return categories;
	}

	public Location getLocation() {
		return location;
	}

	public List<Product> getProducts() {
		return products;
	}

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
	
	public List<Offer> getOffers() {
		return offers;
	}

	public Offer getOffer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Discount> getDiscounts() {
		// TODO Auto-generated method stub
		return null;
	}
}
