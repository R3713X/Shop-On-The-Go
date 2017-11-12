package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Models.ShopModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 03/10/2017
 *
 */
public class ShopController implements IController<ShopModel, String>{
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();

    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /**
     * Initializes the Rest template and adds a
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
    @Override
    public ArrayList<ShopModel> get(){
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
    @Override
    public ShopModel getById(String shopId){
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
     * @shop is the shop that will be created
     * @return the shop that was created
     */
    @Override
    public ShopModel create(ShopModel shop){
        try {
            final String url = "http://localhost:8080/shops";
            return restTemplate.postForObject(url, shop, ShopModel.class);
        }catch (Exception e){
            Log.e("createShop", e.getMessage(),e);
        }
        return null;
    }


    /**
     * Updates an already existing shop.
     * @param shop is the shop that will get updated
     */
    @Override
    public void update(ShopModel shop){
        try {
            final String url = "http://localhost:8080/shops/{id}";
            params.clear();
            params.put("id", shop.getId());
            restTemplate.put(url, shop, params);
        }catch (Exception e) {
            Log.e("updateShop", e.getMessage(), e);
        }
    }

    /**
     * Deletes a shop that exists.
     * @param shopId the id of the shop that will get deleted
     */
    @Override
    public void delete(String shopId){
        try {
            final String url = "http://localhost:8080/shops/{id}";
            params.clear();
            params.put("id", shopId);
            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("getOffers", e.getMessage(),e);
        }
    }
}
