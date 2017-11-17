package com.sirialkillers.shoponthego.Controllers;

import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.Position;

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
 * @version 17/10/2017
 *
 */
public class ShopControllerTest {
    private List<ShopModel> shops;
    private ShopController shopController;
    private Position position;
    private MockMvc mock;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setUp() throws Exception {
        position = new Position(40.6657785,22.9468865);
        shopController = new ShopController();
        shops = shopController.get();

    }

    @Test
    public void readShop() throws Exception{
        mock.perform(get("/shops"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.shops.get(0).getId())))
                .andExpect(jsonPath("$.name", is(this.shops.get(0).getName())))
                .andExpect(jsonPath("$.position", is(this.shops.get(0).getPosition())));

    }

    @Test
    public void readShops() throws Exception{
        mock.perform(get("/shops"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].id", is(this.shops.get(0).getId())))
                .andExpect(jsonPath("$[0].name", is(this.shops.get(0).getName())))
                .andExpect(jsonPath("$[0].position", is(this.shops.get(0).getPosition())))
                .andExpect(jsonPath("$[0].id", is(this.shops.get(1).getId())))
                .andExpect(jsonPath("$[0].name", is(this.shops.get(1).getName())))
                .andExpect(jsonPath("$.position", is(this.shops.get(1).getPosition())));
    }

    @Test
    public void createShop() throws Exception {
        ShopModel shop = new ShopModel("5", "Pizza Della Mamma", position);
        ShopModel shopThatIsCreated = shopController.create(shop);
        assertEquals(shopThatIsCreated.getId(), "5");
        assertEquals(shopThatIsCreated.getName(), "Pizza Della Mamma");
        assertEquals(shopThatIsCreated.getPosition(), position);

        this.mock.perform(post("/shops")
                .contentType(contentType)
                .content((shop.toString())))
                .andExpect(status().isCreated());
    }

    @Test
    public void getShops() throws Exception {
        //TODO create a mock object
        assertNotNull(shops);
    }

    @Test
    public void getShopById() throws Exception {
        ShopModel shop = shopController.getById("2");
        assertEquals(shop.getId(), "2");
    }

    @Test
    public void updateShop() throws Exception {
        ShopModel shop = shopController.getById("2");
        String name = shop.getName();
        shopController.update("2", shop);
        shop = shopController.getById("2");
        assertNotEquals(name, shop.getName());
    }

    @Test
    public void deleteShop() throws Exception {
        shopController.delete("2");
        assertNull(shopController.getById("2"));
    }

    @After
    public void tearDown() throws Exception {
    //TODO create a tearDown structure.
    }
}