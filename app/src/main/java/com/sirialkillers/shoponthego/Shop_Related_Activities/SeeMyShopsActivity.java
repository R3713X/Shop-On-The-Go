package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    ArrayList<String> shopNames = new ArrayList<>();
    ArrayList<String> shopAddresses = new ArrayList<>();
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

                chosenShopId = shopIds.get(position);
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
                List<ShopModel> shopModels = shopController.fetchShopsByUser(userID);

                for(int i = 0;i<shopModels.size();i++){
                    shopNames.add(shopModels.get(i).getName());
                    shopAddresses.add(shopModels.get(i).getAddress()+", "+shopModels.get(i).getCity());
                    shopIds.add(shopModels.get(i).getId());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SeeMyShopsActivity.this, android.R.layout.simple_list_item_single_choice, shopNames);
                sListView.setAdapter(arrayAdapter);

                /*
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
