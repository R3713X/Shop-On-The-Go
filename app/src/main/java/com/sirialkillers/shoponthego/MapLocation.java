package com.sirialkillers.shoponthego;

import java.util.ArrayList;

/**
 * Created by Panagiotis Fakiris on 22/10/2017.
 */


@SuppressWarnings("DefaultFileTemplate")
class MapLocation {
    private String name;
    private double lat;
    private double lon;

    private MapLocation(String name, double lat, double lon) {
        // TODO Auto-generated constructor stub
        this.name=name;
        this.lat=lat;
        this.lon=lon;
    }

    MapLocation() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    double getLat() {
        return lat;
    }

    double getLon() {
        return lon;
    }


    private String[] names = {"MuirsHolden", "McDonalds", "Motorhub", "MilanoFurniture", "BP"};
    private Double[] latitudes = {-33.880037, -33.874381, -33.882494, -33.885611, -33.873966};
    private Double[] longitudes = {151.131253, 151.126948, 151.133984, 151.136831, 151.126889};

    //generates arraylist of shop information
    ArrayList<MapLocation> getShops() {
        ArrayList<MapLocation> shops = new ArrayList<>();
        MapLocation m;
        for (int i = 0; i < names.length; i++) {
            m = new MapLocation(names[i], latitudes[i], longitudes[i]);
            shops.add(m);
        }
        return shops;
    }
}
