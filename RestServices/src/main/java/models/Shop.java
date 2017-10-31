package models;

public class Shop {

	private String name;
	private Location location;
	private static int numberOfShops = 0;
	
	public Shop(String givenName) {
		name = givenName;
		location = new Location();
		numberOfShops++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static int getNumberOfShops() {
		return numberOfShops;
	}
}
