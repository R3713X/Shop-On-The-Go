package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sirialkillers.shoponthego.CacheDatabase.CacheDatabase;
import com.sirialkillers.shoponthego.Models.DiscountModel;
import com.sirialkillers.shoponthego.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 16-Nov-17.
 */

public class DiscountDetailsActivity extends AppCompatActivity{
    TextView title;
    TextView description;
    TextView expirationDate;
    DiscountModel selectedDiscount;
    ListOfDiscounts LoD;
    String dateText;
    String selectedDiscountId;
    CacheDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount_details_activity);
        Intent i = getIntent();
        selectedDiscountId=i.getExtras().getString("discountId");
        mdb= CacheDatabase.getInstance(getApplicationContext());
        selectedDiscount= mdb.discountDao().getSpecificDiscount(selectedDiscountId);
        title= (TextView) findViewById(R.id.discountTitle);
        title.setText(selectedDiscount.getTitle());
        description= (TextView) findViewById(R.id.discountDetails);
        description.setText(selectedDiscount.getDescription());
        expirationDate= (TextView) findViewById(R.id.discountExpirationDate);
        dateText=convertDateToString(selectedDiscount.getExpirationDate());
        expirationDate.setText(dateText);
        //needs code for button saveToWishlist(TODO wishlist)

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CacheDatabase.destroyInstance();
    }

    @Override
    public void onPause() {
        super.onPause();
        CacheDatabase.destroyInstance();
    }


    public String convertDateToString(Date indate)
    {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
        try{
            dateString = sdfr.format( indate );
        }catch (Exception ex ){
            System.out.println(ex);
        }
        return dateString;
    }

}