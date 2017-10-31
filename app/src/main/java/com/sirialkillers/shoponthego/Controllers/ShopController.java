package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.ShopModel;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 *
 */

public class ShopController {
    /**
     * Returns a list of shops that are accessible for further use.
     * @return the list of shops
     */
    public ArrayList<ShopModel> getShops(){
        final String url = "http://localhost:8080/shops";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ShopModel> shops = new ArrayList<>();
        shops = restTemplate.getForObject(url, ShopModel.class);
        return shops;
    }

    /**
     * Returns a shop that matches the shopId.
     * @param shopId The id of the shop
     * @return the shop
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
     * @param id the id of the shop
     * @param name the name of the shop
     * @return the shop that was created
     */
    public ShopModel createShop(int id, String name){
        final String url = "http://localhost:8080/shops";
        ShopModel newShop = new ShopModel(id, name);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, newShop, ShopModel.class);
    }


    /**
     * Updates a already existing shop.
     * @param shopId the id of the shop that will get updated
     * @param name the name that will replace the old name of the shop
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
     * Deletes a shop that exists.
     * @param shopId the id of the shop that will get deleted
     */
    public void deleteShop(int shopId){
        final String url = "http://localhost:8080/shops/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", shopId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, params);
    }
}
