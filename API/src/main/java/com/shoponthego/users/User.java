package com.shoponthego.users;

import java.util.List;

import com.shoponthego.products.Product;

public class User implements IUser {

	private int id;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String country;
	private String region;
	private String city;
	private String address;
	private String postcode;
	private List<Product> wishlist;
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
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

	public List<Product> getWishlist() {
		return wishlist;
	}

	@Override
	public int getUserId() {
		return id;
	}

	@Override
	public String getUserName() {
		return name;
	}

	public List<Product> getWishlistById(String userId) {
			return wishlist;
	}

	public List<Product> getWishlistByName(String userName) {
		return null;
	}
	
}
