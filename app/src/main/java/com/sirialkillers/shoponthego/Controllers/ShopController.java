package com.sirialkillers.shoponthego.Controllers;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.Position;

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
public class ShopController {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();
    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

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
        final String url = "http://localhost:8080/shops";
        return restTemplate.getForObject(url, ShopModel.class);
    }

    /**
     * Returns a shop that matches the shopId.
     * @param shopId The id of the shop
     * @return the shop
     */
    public ShopModel getShopById(String shopId){
        final String url = "http://localhost:8080/shops/{id}";
        params.clear();
        params.put("id", shopId);
        return restTemplate.getForObject(url, ShopModel.class, params);
    }

    /**
     * Creates a new shop.
     * @param id the id of the shop
     * @param name the name of the shop
     * @return the shop that was created
     */
    public ShopModel createShop(String id, String name, Position position){
        final String url = "http://localhost:8080/shops";
        ShopModel newShop = new ShopModel(id, name, position);
        return restTemplate.postForObject(url, newShop, ShopModel.class);
    }


    /**
     * Updates a already existing shop.
     * @param shopId the id of the shop that will get updated
     * @param name the name that will replace the old name of the shop
     */
    public void updateShop(String shopId, String name, Position position){
        final String url = "http://localhost:8080/shops/{id}";
        params.clear();
        params.put("id", shopId);
        ShopModel updatedShop = new ShopModel(shopId, name, position);
        restTemplate.put(url, updatedShop, params);
    }

    /**
     * Deletes a shop that exists.
     * @param shopId the id of the shop that will get deleted
     */
    public void deleteShop(String shopId){
        final String url = "http://localhost:8080/shops/{id}";
        params.clear();
        params.put("id", shopId);
        restTemplate.delete(url, params);
    }
}
