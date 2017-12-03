package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.Offer;
import com.shoponthego.products.Product;
import com.shoponthego.shops.categories.ShopType;
import com.shoponthego.shops.discounts.Discount;
import com.shoponthego.shops.discounts.IDiscount;

@Entity
public class Shop {

	@Id
	private String id;
	private String name;
	
	private Location location;
	
	private String email;
	private String phone;
	private String country;
	private String region;
	private String city;
	private String address;
	private String postcode;
	
	private List<Product> products;
 	private List<Offer> offers;
 	private List<Discount> discounts;
	private List<ShopType> shopTypes;
	
	
	public Shop() {
		
	}
	
	public Shop(String givenId, String givenName, Location shopLocation) {
		discounts = new ArrayList<>();
		products = new ArrayList<>();
		offers = new ArrayList<>();
		shopTypes = new ArrayList<>();
		id = givenId;
		name = givenName;
		location = shopLocation;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getPostcode() {
		return postcode;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public List<ShopType> getShopTypes() {
		return shopTypes;
	}
	 
}
