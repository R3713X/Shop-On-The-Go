package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Interfaces.IController;
import com.sirialkillers.shoponthego.Models.OfferModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 12/11/2017
 *
 */
public class OfferController implements IController<OfferModel, String> {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate;

    /* params is a hash map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params;

    /* Default values */
    OfferModel defaultOffer;

    /**
     * Initializes the Rest template and adds a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public OfferController() {
        defaultOffer = new OfferModel("-1");
        params = new HashMap<>();
        restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    }

    /**
     * Returns a list of offers that are accessible for further use.
     * @return the list of offers
     */
    @Override
    public List<OfferModel> get(){
        List<OfferModel> offers = new ArrayList<>();

        try {
            final String url = "http://localhost:8080/offers";

            offers.addAll(restTemplate.getForObject(url, OfferModel.class));
            return offers;
        }catch (Exception e){
            Log.e("getOffers", e.getMessage(),e);
        }
        return offers;
    }

    /**
     * Returns a offer that matches the offerId.
     * @param offerId The id of the offer
     * @return the offer
     */
    @Override
    public OfferModel getById(String offerId){
        try {
            final String url = "http://localhost:8080/offers/{id}";

            params.clear();
            params.put("id", offerId);

            OfferModel offer =  restTemplate.getForObject(url, OfferModel.class, params);
            return offer;
        }catch (Exception e){
            Log.e("getOfferById", e.getMessage(),e);
        }
        return defaultOffer;
    }

    /**
     * Creates a new offer.
     * @param offer is the offer that will be created
     * @return the offer that was created
     */
    @Override
    public OfferModel create(OfferModel offer){
        try {
            final String url = "http://localhost:8080/offers";

            OfferModel offerThatWasCreated = restTemplate.postForObject(url, offer, OfferModel.class);
            return offerThatWasCreated;
        }catch (Exception e){
            Log.e("CreateOffer", e.getMessage(),e);
        }
        return defaultOffer;
    }

    /**
     * Updates a already existing offer.
     * @param offer is the offer that will get updated.
     */
    @Override
    public void update(String targetOffer, OfferModel offer){
        try {
            final String url = "http://localhost:8080/offers/{targetOffer}";

            params.clear();
            params.put("targetOffer", targetOffer);

            restTemplate.put(url, offer, params);
        }catch (Exception e){
            Log.e("updateOffer", e.getMessage(),e);
        }
    }

    /**
     * Deletes a offer that already exists.
     * @param offerId the id of the offer that will get deleted
     */
    @Override
    public void delete(String offerId){
        try {
            final String url = "http://localhost:8080/offers/{id}";

            params.put("id", offerId);
            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("deleteOffer", e.getMessage(),e);
        }
    }
}
