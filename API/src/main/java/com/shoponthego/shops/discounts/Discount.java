package com.shoponthego.shops.discounts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discount {

	@Id
	private String id;
	private String title;
	private String description;
	private String state;
	private int percentage;
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

	public String getId() {
		return id;
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

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
