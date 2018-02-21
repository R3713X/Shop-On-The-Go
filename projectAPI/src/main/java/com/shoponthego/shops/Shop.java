package com.shoponthego.shops;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shop {

	@Id
	private String id;
	private String name;
	
	private String email;
	private String phone;
	private String country;
	private String region;
	private String city;
	private String address;
	private String postcode;
	
	
	
	public Shop() {
		
	}
	
	public Shop(String givenId, String givenName, String givenEmail, 
				String givenPhone, String givenCountry, String givenRegion,
				String givenCity, String givenAddress, String givenPostCode) {
		
		id = givenId;
		name = givenName;
		email = givenEmail;
		phone = givenPhone;
		country = givenCountry;
		region = givenRegion;

		address = givenAddress;
		postcode = givenPostCode;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
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
}
