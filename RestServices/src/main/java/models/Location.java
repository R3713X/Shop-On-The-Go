package models;

public class Location {

	private double latitude;
	private double longtitude;
	
	public Location() {
		latitude = 0.0;
		longtitude = 0.0;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
	
}
