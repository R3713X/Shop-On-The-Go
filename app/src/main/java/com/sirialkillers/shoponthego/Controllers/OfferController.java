package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.OfferModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate;
    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params;

    public OfferController() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        params = new HashMap<>();
    }

    /**
     * Returns a list of offers that are accessible for further use.
     * @return the list of offers
     */
    public ArrayList<OfferModel> getOffers(){
        final String url = "http://localhost:8080/offers";
        return restTemplate.getForObject(url, OfferModel.class);
    }

    /**
     * Returns a offer that matches the offerId.
     * @param offerId The id of the offer
     * @return the offer
     */
    public OfferModel getOfferById(String offerId){
        final String url = "http://localhost:8080/offers/{id}";
        params.clear();
        params.put("id", offerId);
        return restTemplate.getForObject(url, OfferModel.class, params);
    }

    /**
     * Creates a new offer.
     * @param id the id of the offer
     * @param title the name of the offer
     * @return the offer that was created
     */
    public OfferModel createOffer(String id, String title){
        final String url = "http://localhost:8080/offers";
        OfferModel newOffer = new OfferModel(id, title);
        return restTemplate.postForObject(url, newOffer, OfferModel.class);
    }

    /**
     * Updates a already existing offer.
     * @param offerId the id of the offer that will get updated
     * @param name the name that will replace the old name of the offer
     */
    public void updateOffer(String offerId, String name){
        final String url = "http://localhost:8080/offers/{id}";
        params.clear();
        params.put("id", offerId);
        OfferModel updatedOffer = new OfferModel(offerId, name);
        restTemplate.put(url, updatedOffer, params);
    }

    /**
     * Deletes a offer that already exists.
     * @param offerId the id of the offer that will get deleted
     */
    public void deleteOffer(String offerId){
        final String url = "http://localhost:8080/offers/{id}";
        params.put("id", offerId);
        restTemplate.delete(url, params);
    }
}
