package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Maps_Related_Activities.Position;
import com.sirialkillers.shoponthego.Models.CategoryModel;
import com.sirialkillers.shoponthego.Models.DiscountModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 01/12/2017
 *
 */
public class DiscountController {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();

    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /* Default values */
    private DiscountModel defaultDiscount;

    /**
     * Initializes the default values and the Rest template that adds a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public DiscountController(){
        defaultDiscount = new DiscountModel("-1");
        params = new HashMap<>();
        restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    /**
     * Will try to find discounts that are near the user.
     * @param userLocation the location of the user.
     * @param distance the maximum distance to search for the discounts.
     * @return a list of nearby discounts.
     */
    public List<DiscountModel> fetchNearbyDiscounts(Position userLocation, double distance){
        List<DiscountModel> discounts = new ArrayList<>();
        try{
            final String url = "http://83.212.106.80/{latitude}/{longitude}/{distance}/discounts";
            params.clear();
            params.put("latitude", String.valueOf(userLocation.getLatitude()));
            params.put("longitude", String.valueOf(userLocation.getLongitude()));
            params.put("distance", String.valueOf(distance));

            discounts = restTemplate.getForObject(url, DiscountModel.class, params);
            return discounts;
        }catch(Exception e){
            Log.e("fetchNearbyDiscounts", e.getMessage(), e);
        }
        return discounts;
    }

    /**
     * TODO: Add valid parameters and set up the rest template once the URL is defined.
     * Filters discounts by the categories and by the users position.
     * @param categories a list of categories.
     * @param position the users location at that time.
     * @return a list of discounts.
     */
    public List<DiscountModel> getDiscountsByPositionAndCategory(List<CategoryModel> categories, Position position){
        List<DiscountModel> discounts = new ArrayList<>();
        try {
            final String url ="";
            return discounts;
        }catch (Exception e){
            Log.e("discountsPosCategory", e.getMessage(),e);
        }
        return discounts;
    }
}
