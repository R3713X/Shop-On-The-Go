package com.sirialkillers.shoponthego;

import android.app.Application;

import com.sirialkillers.shoponthego.Controllers.ShopController;
import com.sirialkillers.shoponthego.Models.DiscountModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by User on 16-Nov-17.
 */

public class ListOfDiscounts extends Application{
    List<DiscountModel> discountlist=new ArrayList<>();
    ShopController shopController;

    public void addDiscounts(String shopId){
        discountlist=shopController.getShopDiscounts(shopId);
    }

    public List<DiscountModel> getDiscountlist() {
        return discountlist;
    }


    public DiscountModel getSelectedDiscountById(int discountId) {
        DiscountModel discount = null;
        int id=discountId;
        int s;
        for(DiscountModel discounts:discountlist){
            s=discounts.getDiscountId();
            if(Objects.equals(id,s)){
                discount=discounts;
            }
        }
        
        return discount;
    }


}