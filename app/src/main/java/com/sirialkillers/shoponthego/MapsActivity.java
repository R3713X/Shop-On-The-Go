package com.sirialkillers.shoponthego;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
