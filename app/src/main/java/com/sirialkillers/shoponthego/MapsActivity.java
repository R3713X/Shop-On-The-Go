package com.sirialkillers.shoponthego;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;


import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Marker> shopMarkers = new ArrayList<>();
    String[] names={"MuirsHolden","McDonalds","Motorhub","MilanoFurniture","BP"};
    Double[] lat={-33.880037,-33.874381,-33.882494,-33.885611,-33.873966};
    Double[] lon={151.131253,151.126948,151.133984,151.136831,151.126889};

    private ArrayList<MapLocation> getShops()
    {
        ArrayList<MapLocation> shops= new ArrayList<>();
        MapLocation m;
        for(int i=0;i<names.length;i++)
        {
            m=new MapLocation(names[i], lat[i], lon[i]);
            shops.add(m);
        }
        return shops;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //Initializing the seekbar that controls the radius in which the user can see the shop. Also a textView that will display the meters.
        SeekBar rangeControlSeekBar = (SeekBar) findViewById(R.id.viewingRangeControlBar);
        final TextView radiusDisplayTextView =(TextView) findViewById(R.id.radiusTextView);
        //Setting the maxumum range of the radius to 1500 meters and the (starting) current progress to 750 meters.
        rangeControlSeekBar.setMax(1400);
        rangeControlSeekBar.setProgress(650);
        //need API level 26 to implement the minimum Range of 100 meters
        //If we had it, it would be like this: rangeControlSeekBar.setMin(100); but now we use the realProgress int in the seekBarListener to do the same thing.

        //Initializing a SeekBar Listener to get the range/radius Values.
        rangeControlSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Updating the Textview for the radius as the seekbar progress changes
                //We use realProgress to make the minmum ammount of meters to 100;
                //We should also use realProgress to count the meters of the radius as well.
                int realProgress;
                realProgress=progress+100;
                Log.i("Seekbar", Integer.toString(progress));
                radiusDisplayTextView.setText("Your current radius is: "+Integer.toString(realProgress)+" meters.");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

 ViewShops#2
        // Add a marker for every shop that is contained in list shops.
        // and move the map's camera to the same location.
        ArrayList<MapLocation> shops = new ArrayList<>();
        shops = getShops();
      
        for (int i = 0; i<names.length; i++){
            mMap.addMarker(new MarkerOptions().position(new LatLng(shops.get(i).getLat(), shops.get(i).getLat())).title(shops.get(i).getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(shops.get(i).getLat(), shops.get(i).getLat())));

        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        List<MapLocation> shops=getShops();
        setShopMarkers(shops);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
 development
    }

    public void setShopMarkers(List<MapLocation> shops) {

        shopMarkers.clear();

        for (MapLocation m : shops){
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(m.getLat(), m.getLon()))
                    .title(m.getName())
                    .visible(false));

            shopMarkers.add(marker);
        }


    Circle circle = mMap.addCircle(new CircleOptions()
            .center(mylatLng)
            .radius(400)
            .strokeColor(Color.rgb(0, 136, 255))
            .fillColor(Color.argb(20, 0, 136, 255)));




    for (Marker marker : shopMarkers) {
        if (SphericalUtil.computeDistanceBetween(mylatLng, marker.getPosition()) < 400) {
            marker.setVisible(true);
        }
    }
}
