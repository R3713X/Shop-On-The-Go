package com.sirialkillers.shoponthego;

import com.sirialkillers.shoponthego.Controllers.ShopController;
import com.sirialkillers.shoponthego.Models.DiscountModel;

import java.util.ArrayList;

/**
 * Created by User on 16-Nov-17.
 */

public class ListOfDiscounts {
    ArrayList<DiscountModel> discountlist=new ArrayList<>();
    ShopController shopController;

    public void addDiscounts(String shopId){
        discountlist.clear();
        String id = shopId;
        //Needs implementation of getShopDiscounts on ShopController
        discountlist=shopController.getShopDiscounts(id);
    }

    public ArrayList<DiscountModel> getDiscountlist() {
        return discountlist;
    }


    public DiscountModel getSelectedDiscount(int position){
        DiscountModel discount;
        discount =discountlist.get(position);
        return discount;
    }
}