package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.ShopModel;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ioakeim James Theologou on 31/10/2017.
 * This class is based on Spring Framework and is
 * used as a controller to receive data from the
 * server.
 */

public class ShopController {
    /**
     * Get data as mapped object
     * @returns a list of shops.
     */
    public ArrayList<ShopModel> getShops(){
        final String url = "http://localhost:8080/shops";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ShopModel> shops = new ArrayList<>();
        shops = restTemplate.getForObject(url, ShopModel.class);
        return shops;
    }

    /**
     * Searches for a shop that matches @shopId.
     * @shopId is used to match the shop.
     * @returns a shop that matches the id.
     */
    public ShopModel getShopById(Integer shopId){
        final String url = "http://localhost:8080/shops/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", shopId);
        RestTemplate restTemplate = new RestTemplate();
        ShopModel shop = restTemplate.getForObject(url, ShopModel.class, params);
        return shop;
    }

    /**
     * Creates a new shop.
     * @id is used to set the id of the new shop.
     * @name is used to set the name of the new shop.
     * @returns the new shop that was created.
     */
    public ShopModel createShop(int id, String name){
        final String url = "http://localhost:8080/shops";
        ShopModel newShop = new ShopModel(id, name);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, newShop, ShopModel.class);
    }


    /**
     * Updates a shop.
     * @param shopId is used to set the id of the new shop.
     * @param name is used to set the name of the new shop.
     */
    public void updateShop(int shopId, String name){
        final String url = "http://localhost:8080/shops/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", shopId);
        ShopModel updatedShop = new ShopModel(shopId, name);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, updatedShop, params);
    }

    /**
     * Deletes a shop.
     * @param shopId is used to set the id
     * of the shop that will get deleted.
     */
    public void deleteShop(int shopId){
        final String url = "http://localhost:8080/shops/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", shopId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, params);
    }
}
