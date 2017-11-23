package com.shoponthego.users;

import java.util.List;

import com.shoponthego.products.IProduct;

public class Customer implements IUser {

	private int id;
	private String name;
	private List<IProduct> wishlist;
	private List<IPreference> preferences;
	
	@Override
	public int getUserId() {
		return id;
	}

	@Override
	public String getUserName() {
		return name;
	}

	@Override
	public List<IProduct> getWishlistById(String userId) {
		return wishlist;
	}

	@Override
	public List<IProduct> getWishlistByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPreference> getPreferences(String userId) {
		return preferences;
	}

}
