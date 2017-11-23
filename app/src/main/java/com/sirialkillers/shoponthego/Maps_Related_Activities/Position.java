package com.sirialkillers.shoponthego.Maps_Related_Activities;

/**
 * @author Ioakeim James Theologou
 * @version 03/10/2017
 * TODO: Create a test class for this class.
 */

public class Position {
    private double latitude;
    private double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {

        return latitude;
    }

    public void setLatitude(double latitude) {

        this.latitude = latitude;
    }

    public double getLongitude() {

        return longitude;
    }

    public void setLongitude(double longitude) {

        this.longitude = longitude;
    }
}
