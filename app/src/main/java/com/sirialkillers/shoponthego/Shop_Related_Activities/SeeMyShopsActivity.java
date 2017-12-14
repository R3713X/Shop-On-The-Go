package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sirialkillers.shoponthego.Controllers.ShopController;
import com.sirialkillers.shoponthego.MenuActivity;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.R;

import java.util.ArrayList;
import java.util.List;

public class SeeMyShopsActivity extends AppCompatActivity {
    private RequestShopsByUserIdTask requestShopsByUserIdTask = null;
    ListView sListView;
    List<ShopModel> shopModels;

    ArrayList<String> shopIds = new ArrayList<>();
    ConstraintLayout constraintLayout;
    ProgressBar progressBar;
    TextView loadingTextView;
    String chosenShopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_my_shops);
        progressBar = findViewById(R.id.progressBar);
        loadingTextView = findViewById(R.id.loadingTextView);
        constraintLayout = findViewById(R.id.constraintLayout2);
        sListView = findViewById(R.id.shopListView);
        requestShopsByUserIdTask = new RequestShopsByUserIdTask("1");
        requestShopsByUserIdTask.execute((Void) null);

        sListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),shopModels.get(position).getName()+" selected",Toast.LENGTH_LONG).show();
                chosenShopId = shopModels.get(position).getId();
                goToAddDiscountActivity();

            }
        });

    }

    /***
     * This is a Request that gets the shop models of this owner and
     * displays their names and address in the listview
     */

    public class RequestShopsByUserIdTask extends AsyncTask<Void, Boolean, Boolean> {

        String  userID;

        public RequestShopsByUserIdTask(String userID) {
            userID = userID;
        }

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try
            {
                ShopController shopController = new ShopController();

                shopModels = shopController.fetchShopsByUser(userID);

                SeeMyShopsCustomAdapter adapter;
                adapter= new SeeMyShopsCustomAdapter(getApplicationContext(),shopModels);
                sListView.setAdapter(adapter);



            } catch (Exception e){

                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {
                progressBar.setVisibility(View.INVISIBLE);
                loadingTextView.setVisibility(View.INVISIBLE);
                constraintLayout.setVisibility(View.VISIBLE);

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
        intent.putExtra("chosenShopId",chosenShopId);
        startActivity(intent);
        finish();
    }
}
