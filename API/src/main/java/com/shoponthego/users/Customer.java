package com.shoponthego.users;

import java.util.List;

import com.shoponthego.products.Product;

public class Customer implements IUser {

	private int id;
	private String name;
	private List<Product> wishlist;
	
	
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
