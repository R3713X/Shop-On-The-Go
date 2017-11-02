package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.OfferModel;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 02/10/2017
 *
 */
public class OfferController {
    /**
     * Returns a list of offers that are accessible for further use.
     * @return the list of offers
     */
    public ArrayList<OfferModel> getOffers(){
        final String url = "http://localhost:8080/offers";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<OfferModel> offers;
        offers = restTemplate.getForObject(url, OfferModel.class);
        return offers;
    }

    /**
     * Returns a offer that matches the offerId.
     * @param offerId The id of the offer
     * @return the offer
     */
    public OfferModel getOfferById(Integer offerId){
        final String url = "http://localhost:8080/offers/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", offerId);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, OfferModel.class, params);
    }

    /**
     * Creates a new offer.
     * @param id the id of the offer
     * @param name the name of the offer
     * @return the offer that was created
     */
    public OfferModel createOffer(int id, String name){
        final String url = "http://localhost:8080/offers";
        OfferModel newOffer = new OfferModel(id, name);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, newOffer, OfferModel.class);
    }

    /**
     * Updates a already existing offer.
     * @param offerId the id of the offer that will get updated
     * @param name the name that will replace the old name of the offer
     */
    public void updateOffer(int offerId, String name){
        final String url = "http://localhost:8080/offers/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", offerId);
        OfferModel updatedOffer = new OfferModel(offerId, name);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, updatedOffer, params);
    }

    /**
     * Deletes a offer that exists.
     * @param offerId the id of the offer that will get deleted
     */
    public void deleteOffer(int offerId){
        final String url = "http://localhost:8080/offers/{id}";
        Map<String, Integer> params = new HashMap<>();
        params.put("id", offerId);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, params);
    }
}
