package com.shoponthego.locations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	private int id;
	private String name;
	private double longtitude;
	private double latitude;
	
	public Location(String name, double longtitude, double latitude) {
		super();
		this.name = name;
		this.longtitude = longtitude;
		this.latitude = latitude;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
