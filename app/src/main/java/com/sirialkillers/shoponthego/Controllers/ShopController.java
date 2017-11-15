package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Models.OfferModel;
import com.sirialkillers.shoponthego.Models.ShopModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 15/11/2017
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
    public List<ShopModel> get(){
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
            final String url = "http://localhost:8080/shops/{shopId}";
            params.clear();
            params.put("shopId", shopId);
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
    public void update(String targetShop, ShopModel shop){
        try {
            final String url = "http://localhost:8080/shops/{targetShop}";
            params.clear();
            params.put("targetShop", targetShop);
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
            final String url = "http://localhost:8080/shops/{shopId}";
            params.clear();
            params.put("shopId", shopId);
            restTemplate.delete(url, params);

        }catch (Exception e){
            Log.e("getOffers", e.getMessage(),e);
        }
    }

    /**
     * returns a list of offers that are available
     * from that certain shop that matches the shopId.
     * @param shopId the shop that will return its offers.
     * @return a list of offers
     */
    public List<OfferModel> getShopOffers(String shopId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers";
            params.clear();
            params.put("shopId",shopId);
            return restTemplate.getForObject(url, OfferModel.class, params);

        }catch (Exception e){
            Log.e("getShopOffers", e.getMessage(),e);
        }
        return null;
    }

    /**
     * returns a offer that matches the shop and offer ID.
     * @param shopId the shop to match.
     * @param offerId the offer to match.
     * @return a offer.
     */
    public OfferModel getShopOffer(String shopId, String offerId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";
            params.clear();
            params.put("shopId",shopId);
            params.put("offerId", offerId);
            return restTemplate.getForObject(url, OfferModel.class, params.get(0), params.get(1));

        }catch (Exception e){
            Log.e("getShopOffer", e.getMessage(),e);
        }
        return null;
    }

    /**
     * creates a new offer and adds it to the shop that matches the shopId.
     * @param shopId the shop that will add the offer.
     * @param offer the offer that will be added.
     */
    public void addShopOffer(String shopId, OfferModel offer){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers";
            params.clear();
            params.put("shopId", shopId);
            restTemplate.postForObject(url, offer, OfferModel.class, params);

        }catch (Exception e){
            Log.e("addShopOffer", e.getMessage(),e);
        }
    }

    /**
     * updates an already existing offer from a shop.
     * @param shopId the shop that has the offer.
     * @param offerId the offer that will get updated.
     * @param offer the offer that will replace the old offer.
     */
    public void updateShopOffer(String shopId, String offerId,  OfferModel offer){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";
            params.clear();
            params.put("shopId", shopId);
            params.put("offerId", offerId);
            restTemplate.put(url, offer, params.get(0), params.get(1));

        }catch (Exception e){
            Log.e("updateShopOffer", e.getMessage(),e);
        }
    }

    /**
     * deletes a offer from a shop.
     * @param shopId the shop that has the offer.
     * @param offerId the offer that will get deleted.
     */
    public void deleteShopOffer(String shopId, String offerId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";
            params.clear();
            params.put("shopId", shopId);
            params.put("offerId", offerId);
            restTemplate.delete(url, params.get(0), params.get(1));

        }catch (Exception e){
            Log.e("deleteShopOffer", e.getMessage(),e);
        }
    }
}
