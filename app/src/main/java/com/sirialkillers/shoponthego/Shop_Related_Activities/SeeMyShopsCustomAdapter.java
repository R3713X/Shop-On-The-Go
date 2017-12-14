package com.sirialkillers.shoponthego.Shop_Related_Activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.R;

import java.util.List;

/**
 * Created by Giannis on 11/12/2017.
 */

class SeeMyShopsCustomAdapter extends BaseAdapter{

    private Context context;
    private List<ShopModel> shopModels;

    public SeeMyShopsCustomAdapter(Context context, List<ShopModel> shopModels) {
        this.context = context;
        this.shopModels = shopModels;
    }

    @Override
    public int getCount() {
        return shopModels.size();
    }

    @Override
    public Object getItem(int position) {
        return shopModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context,R.layout.see_shops_custom_row,null);
        TextView shopName = (TextView) v.findViewById(R.id.shopNameTextView);
        TextView shopAddress = (TextView) v.findViewById(R.id.shopAddressTextView);
        //Set text for Textview
        shopName.setText(shopModels.get(position).getName());
        shopAddress.setText(shopModels.get(position).getAddress()+", "+shopModels.get(position).getCity());

        //Save shop to id tag

        v.setTag(shopModels.get(position).getId());


        return v;
    }


}
