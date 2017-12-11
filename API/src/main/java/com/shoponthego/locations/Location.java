package com.shoponthego.locations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	private int id;
	private double longtitude;
	private double latitude;
	
	public Location(double longtitude, double latitude) {
		super();
		this.longtitude = longtitude;
		this.latitude = latitude;
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
