package com.sirialkillers.shoponthego.Controllers;
import android.util.Log;

import com.sirialkillers.shoponthego.Models.DiscountModel;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.Position;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 03/10/2017
 *
 */
public class ShopController {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();
    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /**
     * Initializes the Rest template and add a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public ShopController() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        params = new HashMap<>();
    }

    /**
     * Returns a list of shops that are accessible for further use.
     * @return the list of shops
     */
    public ArrayList<ShopModel> getShops(){
        try {
            final String url = "http://localhost:8080/shops";
            return restTemplate.getForObject(url, ShopModel.class);
        }catch (Exception e){
            Log.e("getShops", e.getMessage(),e);
        }
        return null;
    }

    /**
     * Returns a shop that matches the shopId.
     * @param shopId The id of the shop
     * @return the shop
     */
    public ShopModel getShopById(String shopId){
        try {
            final String url = "http://localhost:8080/shops/{id}";
            params.clear();
            params.put("id", shopId);
            return restTemplate.getForObject(url, ShopModel.class, params);
        }catch (Exception e){
            Log.e("getShopById", e.getMessage(),e);
        }
        return null;
    }

    /**
     * Creates a new shop.
     * @param id the id of the shop
     * @param name the name of the shop
     * @param position the longitude and latitude of the shop.
     * @return the shop that was created
     */
    public ShopModel createShop(String id, String name, Position position){
        try {
            final String url = "http://localhost:8080/shops";
            ShopModel newShop = new ShopModel(id, name, position);
            return restTemplate.postForObject(url, newShop, ShopModel.class);
        }catch (Exception e){
            Log.e("createShop", e.getMessage(),e);
        }
        return null;
    }


    /**
     * Updates an already existing shop.
     * @param shopId the id of the shop that will get updated
     * @param name the name that will replace the old name of the shop
     * @param position the new latitude and longitude of the shop.
     */
    public void updateShop(String shopId, String name, Position position){
        try {
            final String url = "http://localhost:8080/shops/{id}";
            params.clear();
            params.put("id", shopId);
            ShopModel updatedShop = new ShopModel(shopId, name, position);
            restTemplate.put(url, updatedShop, params);
        }catch (Exception e) {
            Log.e("updateShop", e.getMessage(), e);
        }
    }

    /**
     * Deletes a shop that exists.
     * @param shopId the id of the shop that will get deleted
     */
    public void deleteShop(String shopId){
        try {
            final String url = "http://localhost:8080/shops/{id}";
            params.clear();
            params.put("id", shopId);
            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("getOffers", e.getMessage(),e);
        }
    }

    public List<DiscountModel> getShopDiscounts(String shopId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts";
            params.clear();
            params.put("shopId",shopId);
            return restTemplate.getForObject(url, DiscountModel.class, params);

        }catch (Exception e){
            Log.e("getShopDiscounts", e.getMessage(),e);
        }
        return null;
    }

    /**
     * returns a discount that matches the shop and discount ID.
     * @param shopId the shop to match.
     * @param discountId the discount to return.
     * @return a discount.
     */
    public DiscountModel getShopDiscount(String shopId, String discountId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts/{discountId}";
            params.clear();
            params.put("shopId",shopId);
            params.put("discountId", discountId);
            return restTemplate.getForObject(url, DiscountModel.class, params.get(0), params.get(1));

        }catch (Exception e){
            Log.e("getShopDiscount", e.getMessage(),e);
        }
        return null;
    }
}
