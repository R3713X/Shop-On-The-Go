package com.sirialkillers.shoponthego;

/**
 * Created by User on 19-Oct-17.
 */

public class MapLocation {
    private String name;
    private double lat;
    private double lon;

    public MapLocation(String name,double lat, double lon) {
        // TODO Auto-generated constructor stub
        this.name=name;
        this.lat=lat;
        this.lon=lon;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLt(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
