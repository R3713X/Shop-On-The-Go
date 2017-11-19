package com.sirialkillers.shoponthego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements OnClickListener {
    private Button buttonMap;
    private Button buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(this);
        buttonList = (Button) findViewById(R.id.buttonList);
        buttonList.setOnClickListener(this);
        Button addDiscount = (Button) findViewById(R.id.addDiscountButton);
        addDiscount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddDiscountActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonMap:
                Intent intentStartNextActivity = new Intent(this, MapsActivity.class);
                startActivity(intentStartNextActivity);
                break;
            case R.id.buttonList:
                Intent intentStartListActivity = new Intent(this, ShopsListView.class);
                startActivity(intentStartListActivity);
            default:
                break;
        }
    }

}



