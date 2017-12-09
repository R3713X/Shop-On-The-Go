package com.sirialkillers.shoponthego;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;

import com.sirialkillers.shoponthego.CacheDatabase.CacheDatabase;
import com.sirialkillers.shoponthego.Maps_Related_Activities.Position;
import com.sirialkillers.shoponthego.Models.ShopModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by User on 02-Dec-17.
 */
@RunWith(AndroidJUnit4.class)
public class CacheDatabaseWriteReadTest {
    private CacheDatabase mDb;
    Context ctx;


    @Before
    public void createDB(){
        ctx=InstrumentationRegistry.getContext();
        mDb=CacheDatabase.getInstance(ctx);
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void testIfDatabaseIsOpen(){
        boolean isOpen=mDb.isOpen();
        assertTrue(isOpen);
    }

    @Test
    public void writeShopAndReadInList() throws Exception {
        ShopModel testShop=new ShopModel("1223","testShop", new Position(40.6657785,22.9468865));
        mDb.shopDao().insertAllShops(testShop);
        List<ShopModel> byName = mDb.shopDao().getShopsByName("testShop");
        assertThat(byName.get(0), equalTo(testShop));
    }



}
