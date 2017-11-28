package com.shoponthego.users;

import java.util.List;

import com.shoponthego.products.Product;

public interface IUser {

	public int getUserId();
	public String getUserName();
	public List<Product> getWishlistById(String userId);
	public List<Product> getWishlistByName(String userName);
	
}
