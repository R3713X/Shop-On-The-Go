package com.sirialkillers.shoponthego;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private BroadcastReceiver broadcastReceiver;
    LatLng userLocation;
    //This will be the radius of the circle in which we can see the shops of the map
    int realProgress=750;
    MapLocation mp=new MapLocation();

    List<Marker> shopMarkers = new ArrayList<>();
    //creating a circle that would signify the viewing range on the map
    private CircleOptions circle = new CircleOptions()
            .strokeColor(Color.rgb(0, 136, 255))
            .fillColor(Color.argb(50, 0, 136, 255))
            .radius(realProgress);
    //arrays to initialize markers, to be removed when database is connected
    Circle myCircle;
    





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(!runtime_permissions()){
            Intent intent=new Intent(getApplicationContext(),GPS_Service.class);
            startService(intent);

        }


        //Initializing the seekbar that controls the radius in which the user can see the shop. Also a textView that will display the meters.
        SeekBar rangeControlSeekBar = (SeekBar) findViewById(R.id.viewingRangeControlBar);
        final TextView radiusDisplayTextView = (TextView) findViewById(R.id.radiusTextView);
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
                //We use realProgress to make the minimum ammount of meters to 100;
                //Changing the circles color while it changes attributes
                circle
                        .center(userLocation)
                        .radius(realProgress)
                        .strokeColor(Color.rgb(127,255,0))
                        .fillColor(Color.argb(50, 127,255,0));


                realProgress = progress + 100;
                Log.i("Seekbar", Integer.toString(progress));
                radiusDisplayTextView.setText("Your current radius is: " + Integer.toString(realProgress) + " meters.");

                SeekMap(mMap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                circle
                        .strokeColor(Color.rgb(127,255,0))
                        .fillColor(Color.argb(50, 127,255,0));

                SeekMap(mMap);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                circle
                        .strokeColor(Color.rgb(0, 136, 255))
                        .fillColor(Color.argb(50, 0, 136, 255));

                SeekMap(mMap);

            }
        });

        checkForUpdates(); //Used for HockeyApp
    }

    //CrashReporting and Beta-Distribution for HockeyApp.
  @Override
  public void onResume() {
    super.onResume();
    // ... your own onResume implementation
    checkForCrashes();
  }
  //CrashReporting and Beta-Distribution for HockeyApp.
  @Override
  public void onPause() {
    super.onPause();
    unregisterManagers();
  }
  //CrashReporting and Beta-Distribution for HockeyApp.
  @Override
  public void onDestroy() {
    super.onDestroy();
    unregisterManagers();
  }
  //CrashReporting and Beta-Distribution for HockeyApp.
  private void checkForCrashes() {
    CrashManager.register(this);
  }
  //CrashReporting and Beta-Distribution for HockeyApp.
  private void checkForUpdates() {
    // Remove this for store builds!
    UpdateManager.register(this);
  }
  //CrashReporting and Beta-Distribution for HockeyApp.
  private void unregisterManagers() {
    UpdateManager.unregister();
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

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final List<MapLocation> shops = mp.getShops();
        if (broadcastReceiver==null){
            broadcastReceiver=new BroadcastReceiver() {

                public void onReceive(Context context, Intent intent) {

                    userLocation=new LatLng(intent.getExtras().getDouble("Lat"),intent.getExtras().getDouble("Long"));
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconbluedot)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
                    setShopMarkers(shops);
                    circle.center(userLocation);
                    myCircle = mMap.addCircle(circle);
                    ShowShopMarkers();

                }
            };
            registerReceiver(broadcastReceiver,new IntentFilter("location update"));
        }



        // Add a marker for every shop that is contained in list shops.
        // and move the map's camera to the same location.



        /*for (int i = 0; i<names.length; i++){
            mMap.addMarker(new MarkerOptions().position(new LatLng(shops.get(i).getLat(), shops.get(i).getLat())).title(shops.get(i).getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(shops.get(i).getLat(), shops.get(i).getLat())));

        }*/


    }
    //This redraws the map elements whenever we interact with the SeekBar
    public void SeekMap(GoogleMap mMap){
        final List<MapLocation> shops = mp.getShops();

        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.iconbluedot)));
        setShopMarkers(shops);
        myCircle=mMap.addCircle(circle);
        ShowShopMarkers();
    }




    //Sets the shop markers for all the shops on the map.
    public void setShopMarkers(List<MapLocation> shops) {

        shopMarkers.clear();

        for (MapLocation m : shops) {
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(m.getLat(), m.getLon()))
                    .title(m.getName())
                    .visible(false));


            shopMarkers.add(marker);
        }
    }
         //Shows the shop markers inside chosen radius
        public void  ShowShopMarkers(){

        for (Marker marker : shopMarkers) {
            if (SphericalUtil.computeDistanceBetween(userLocation, marker.getPosition()) < realProgress) {
                marker.setVisible(true);
            }else{
                marker.setVisible(false);
            }

        }
    }




    private boolean runtime_permissions() {
        if(Build.VERSION.SDK_INT>=23 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){

            requestPermissions(new  String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},100);
            return true;

        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(getApplicationContext(), GPS_Service.class);
                startService(intent);
            } else {
                runtime_permissions();
            }

        }
    }
}
