package com.sirialkillers.shoponthego.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ioakeim on 31/10/2017.
 */

public class ShopModel extends ArrayList{
    private int id;
    private String name;
    //TODO: Create a structure for the position.

    public ShopModel(int initialCapacity, int id, String name) {
        super(initialCapacity);
        this.id = id;
        this.name = name;
    }

    public ShopModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ShopModel(@NonNull Collection c, int id, String name) {
        super(c);
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
