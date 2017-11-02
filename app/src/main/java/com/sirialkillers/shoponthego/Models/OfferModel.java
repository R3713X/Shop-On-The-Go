package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 *
 */

public class OfferModel extends ArrayList {
    private int id;
    private String name;
    private String state;

    public OfferModel(int id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public OfferModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
