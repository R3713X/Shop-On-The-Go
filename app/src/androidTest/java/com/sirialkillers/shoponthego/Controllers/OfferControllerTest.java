package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.OfferModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Ioakeim James Theologou
 * @version 03/10/2017
 */
public class OfferControllerTest {
    private OfferController offerController;
    private ArrayList<OfferModel> actualOffers;
    private ArrayList<OfferModel> offers;


    @Before
    public void setUp() throws Exception {
        offerController = new OfferController();
        offers = offerController.getOffers();
        actualOffers.add((new OfferModel("1", "I'm a human")));

    }

    @Test
    public void getOffers() throws Exception {
        //TODO create a mock object
        assertEquals(offers,actualOffers);
    }

    @Test
    public void getOfferById() throws Exception {
        OfferModel offer = offerController.getOfferById("2");
        assertEquals(offer.getId(), "2");
    }

    @Test
    public void createOffer() throws Exception {
        OfferModel offer = new OfferModel("1", "Just keep it up");
        assertEquals(offer.getId(), "1");
        assertEquals(offer.getTitle(), "Just keep it up");
    }

    @Test
    public void updateOffer() throws Exception {
        String title;
        OfferModel offer = offerController.getOfferById("2");
        title = offer.getTitle();
        offerController.updateOffer("2", "I'm sexy and I know it");
        offer = offerController.getOfferById("2");
        assertNotEquals(title, offer.getTitle());
    }

    @Test
    public void deleteOffer() throws Exception {
        offerController.deleteOffer("2");
        assertEquals(offerController.getOfferById("2"), null);
    }

    @After
    public void tearDown() throws Exception {
        //TODO create a tearDown structure.
    }
}