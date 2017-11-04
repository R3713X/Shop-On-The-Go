package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.Position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Ioakeim James Theologou
 * @version 02/10/2017
 *
 */
public class ShopControllerTest {
    private ArrayList<ShopModel> shops;
    private ArrayList<ShopModel> actualShops;
    private ShopController shopController;
    private ShopModel shop;
    private Position position;

    @Before
    public void setUp() throws Exception {
        position.setLatitude(40.6657785);
        position.setLongitude(22.9468865);
        shops = shopController.getShops();
        shop = new ShopModel("1", "Tesco", position);
        actualShops.add(new ShopModel("1", "Tesco", position));

    }

    @Test
    public void getShops() throws Exception {
        //TODO create a mock object
        assertEquals(shops, actualShops);
    }

    @Test
    public void getShopById() throws Exception {
        ShopModel shop = shopController.getShopById("2");
        assertEquals(shop.getId(), "2");
    }

    @Test
    public void createShop() throws Exception  {
       ShopModel shop = shopController.createShop("5", "Pizza Della Mamma", position);
       assertEquals(shop.getId(), "5");
       assertEquals(shop.getName(), "Pizza Della Mamma");
       assertEquals(shop.getPosition(), position);
    }

    @Test
    public void updateShop() throws Exception {
        String name;
        ShopModel shop = shopController.getShopById("2");
        name = shop.getName();
        shopController.updateShop("2", "Booyah!", position);
        shop = shopController.getShopById("2");
        assertNotEquals(name, shop.getName());
    }

    @Test
    public void deleteShop() throws Exception {
        shopController.deleteShop("2");
        assertEquals(shopController.getShopById("2"), null);
    }

    @After
    public void tearDown() throws Exception {
    //TODO create a tearDown structure.
    }
}