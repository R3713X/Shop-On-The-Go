package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.List;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.IOffer;
import com.shoponthego.products.IProduct;
import com.shoponthego.shops.categories.ICategory;
import com.shoponthego.shops.discounts.IDiscount;

public class Shop implements IShop {

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
	
	private List<IProduct> products;
 	private List<IOffer> offers;
 	private List<IDiscount> discounts;
	private List<ICategory> categories;
	
	
	public Shop() {
		
	}
	
	public Shop(String givenId, String givenName, Location shopLocation) {
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

	public List<IProduct> getProducts() {
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
	
	public List<IOffer> getOffers() {
		return offers;
	}

	public IOffer getOffer(String id) {
		return null;
	}

	public List<IDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<IDiscount> discounts) {
		this.discounts = discounts;
	}

	/*
	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPhoneNumber() {
		return phone;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public String getRegion() {
		// TODO Auto-generated method stub
		return region;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public String getPostcode() {
		// TODO Auto-generated method stub
		return postcode;
	}
	*/
}
