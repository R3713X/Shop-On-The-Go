package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SeeMyShopsActivity extends AppCompatActivity {
    private RequestShopsByUserIdTask requestShopsByUserIdTask = null;
    ListView sListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_shops);
        sListView = findViewById(R.id.shopListView);


    }

    /***
     * This is a Request that gets the shop models of this owner and
     * displays their names and address in the listview
     */

    public class RequestShopsByUserIdTask extends AsyncTask<Void, Boolean, Boolean> {



        @Override
        protected void onPreExecute() {


        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try
            {
               /*return a list of Shop Models using getShopsByUserId
               create another list that has only the names of the shop models
               optionally get the address of the shop models as well
               and display them in the list view*/

            } catch (Exception e){

                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {


            } else {
                Toast.makeText(SeeMyShopsActivity.this, "Something went wrong!!! Try again", Toast.LENGTH_LONG).show();
                goToMenuActivity();
            }
        }

        @Override
        protected void onCancelled() {
            requestShopsByUserIdTask = null;
        }
    }


    private void goToMenuActivity(){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
        finish();
    }
    private void goToAddDiscountActivity(){
        Intent intent = new Intent(getApplicationContext(), AddDiscountActivity.class);
        startActivity(intent);
        finish();
    }
}
