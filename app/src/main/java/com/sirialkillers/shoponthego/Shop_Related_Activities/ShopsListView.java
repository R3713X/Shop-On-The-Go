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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_list_view);
        ListOfShops LoS = new ListOfShops();
        CacheDatabase mdb= Room.databaseBuilder(getApplicationContext(),CacheDatabase.class,"local-database").build();
        lv= (ListView) findViewById(R.id.shopsListView);
        sv= (SearchView) findViewById(R.id.shopsSearchView);
        List<ShopModel> shopsList;
        shopsList= mdb.shopDao().getAllShops();
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
