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
    private String id;
    private String title;
    private String state;
    private Date date;

    public OfferModel(String id, String title, String state, Date date) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.date = date;
    }

    public OfferModel(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public Date getDate(){
        return date;
    }
}
