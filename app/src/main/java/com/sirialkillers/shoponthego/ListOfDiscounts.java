package com.sirialkillers.shoponthego;


import com.sirialkillers.shoponthego.Controllers.ShopController;
import com.sirialkillers.shoponthego.Models.DiscountModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 16-Nov-17.
 */

public class ListOfDiscounts{
    List<DiscountModel> discountlist=new ArrayList<>();
    ShopController shopController;

    public void addDiscounts(String shopId){
        discountlist.add(new DiscountModel(shopId,"1",30,"discount1", "This is a random description for mock discount 1",new Date()));
        discountlist.add(new DiscountModel(shopId,"2",25,"discount2", "This is a random description for mock discount 2",new Date()));
        discountlist.add(new DiscountModel(shopId,"3",30,"discount3", "This is a random description for mock discount 3",new Date()));
        discountlist.add(new DiscountModel(shopId,"1",30,"discount1", "This is a random description for mock discount 1",new Date()));
    }

    public List<DiscountModel> getDiscountlist() {

        return discountlist;
    }



}