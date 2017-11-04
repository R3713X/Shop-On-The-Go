package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.OfferModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ioakeim James Theologou
 * @version 04/10/2017
 */
public class OfferControllerTest {
    private OfferController offerController;

    private List<OfferModel> offers;

    private OfferModel offer;

    private MockMvc mock;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setUp() throws Exception {
        offerController = new OfferController();
        offers = offerController.getOffers();
    }

    @Test
    public void readOffer() throws Exception{
        mock.perform(get("/offers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.offers.get(0).getId())))
                .andExpect(jsonPath("$.title", is(this.offers.get(0).getTitle())));
    }

    @Test
    public void readOffers() throws Exception{
        mock.perform(get("/offers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].id", is(this.offers.get(0).getId())))
                .andExpect(jsonPath("$[0].title", is(this.offers.get(0).getTitle())))
                .andExpect(jsonPath("$[0].id", is(this.offers.get(1).getId())))
                .andExpect(jsonPath("$[0].title", is(this.offers.get(1).getTitle())));
    }

    @Test
    public void createOffer() throws Exception {
        OfferModel offer = (new OfferModel("1", "Just keep it up"));
        assertEquals(offer.getId(), "1");
        assertEquals(offer.getTitle(), "Just keep it up");

        this.mock.perform(post("/offers")
                .contentType(contentType)
                .content((offer.toString())))
                .andExpect(status().isCreated());
    }

    @Test
    public void getOffers() throws Exception {
        //TODO create a mock object
        assertNotNull(offers);
    }

    @Test
    public void getOfferById() throws Exception {
        OfferModel offer = offerController.getOfferById("2");
        assertEquals(offer.getId(), "2");
    }

    @Test
    public void updateOffer() throws Exception {
        offer = offerController.getOfferById("2");
        String title = offer.getTitle();
        offerController.updateOffer("2", "This content just changed.");
        offer = offerController.getOfferById("2");
        assertNotEquals(title, offer.getTitle());
    }

    @Test
    public void deleteOffer() throws Exception {
        offerController.deleteOffer("2");
        assertNull(offerController.getOfferById("2"));
    }

    @After
    public void tearDown() throws Exception {
        //TODO create a tearDown structure.
    }
}