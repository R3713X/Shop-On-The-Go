package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 * TODO: Create a test class for this model.
 *
 */

public class OfferModel extends ArrayList {
    String offerId;
    String title;
    String description;
    Date expirationDate;

    OfferModel offer = new OfferModel();

    public OfferModel(){

    }

    public OfferModel(OfferModel offer) {

        this.offer = offer;
    }

    public OfferModel(String title) {

        this.title = title;
    }

    public String getOfferId() {

        return offerId;
    }

    public String getTitle() {

        return title;
    }
}
