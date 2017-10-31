package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 *
 */

public class ShopModel extends ArrayList{
    private int id;
    private String name;
    //TODO: Create a structure for the position

    public ShopModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
