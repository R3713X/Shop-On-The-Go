package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.sirialkillers.shoponthego.CacheDatabase.CacheDatabase;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.R;

import java.util.List;

public class    ShopsListView extends AppCompatActivity{
    ListView lv;
    SearchView sv;
    CacheDatabase mdb;
    ListOfShops LoS;
    List<ShopModel> shopsList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_list_view);
        LoS = new ListOfShops();
        mdb= CacheDatabase.getInstance(getApplicationContext());
        lv= (ListView) findViewById(R.id.shopsListView);
        sv= (SearchView) findViewById(R.id.shopsSearchView);
        shopsList= mdb.shopDao().getAllShops();
        callAdapter(shopsList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CacheDatabase.destroyInstance();
    }

    @Override
    public void onResume() {
        super.onResume();
        mdb= Room.databaseBuilder(getApplicationContext(),CacheDatabase.class,"local-database").allowMainThreadQueries().build();
        shopsList= mdb.shopDao().getAllShops();

    }

    public void callAdapter(List<ShopModel> shopsList){
        //ADAPTER
        final ShopListAdapter adapter=new ShopListAdapter(this, shopsList);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
    });
}
    }
