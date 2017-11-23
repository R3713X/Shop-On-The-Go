package com.shoponthego.users;

import java.util.List;

import com.shoponthego.products.IProduct;

public interface IUser {

	public int getUserId();
	public String getUserName();
	public List<IProduct> getWishlistById(String userId);
	public List<IProduct> getWishlistByName(String userName);
	public List<IPreference> getPreferences(String userId);
	
}
