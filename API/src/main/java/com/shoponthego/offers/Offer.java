package com.shoponthego.offers;

import java.util.Date;

public class Offer {

	private String id;
	private String title;
	private String description;
	private String state;
	private Date date;
	
	public Offer() {
		
	}
	
	public Offer(String givenId, String givenTitle, String givenDescription, String givenState) {
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

	public String getId() {
		return id;
	}
	
}
