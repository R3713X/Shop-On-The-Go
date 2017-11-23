package com.shoponthego.shops.discounts;

import java.util.Date;

public class Discount implements IDiscount {

	private String id;
	private String title;
	private String description;
	private String state;
	private Date date;
	
	public Discount() {
		
	}
	
	public Discount(String givenId, String givenTitle, String givenDescription, String givenState) {
		title = givenTitle;
		description = givenDescription;
		id = givenId;
		state = givenState;
		date = new Date();
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getState() {
		return state;
	}

	public String getDate() {
		return date.toString();
	}

	@Override
	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		return id;
	}
	
}
