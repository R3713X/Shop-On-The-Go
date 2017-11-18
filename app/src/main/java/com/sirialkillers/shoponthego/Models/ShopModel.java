package com.sirialkillers.shoponthego.Models;

import com.sirialkillers.shoponthego.Position;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ioakeim James Theologou
 * @version 31/10/2017
 * TODO: Create a test class for this model.
 *
 */

public class ShopModel extends ArrayList{
    private String id;
    private String name;
    private Position position;

    public ShopModel(String id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
