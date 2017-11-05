package com.sirialkillers.shoponthego;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by User on 04-Nov-17.
 */

public class ListAdapterTest {

    private ListAdapter listAdapter;
    private ArrayList<Shop> shops;

    @Before
    public void setUp() throws Exception{
        Context context = Mockito.mock(Context.class);
        populateListOfShops();
        listAdapter=new ListAdapter(context, shops);
    }

    private void populateListOfShops()
    {
        shops= new ArrayList<>();
        shops.add(new Shop("rafaele", 40.6657785, 22.9468865));
        shops.add(new Shop("mavidis", 40.6666259,22.9455427));
        shops.add(new Shop("porkys", 40.663449,22.9475822));
        shops.add(new Shop("seven", 40.6595399,22.9445063));
        shops.add(new Shop("mad gym",40.6566813,22.9328894));
    }
    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( listAdapter );
    }

    @Test
    public void getCount_ReturnCorrectCount() throws Exception
    {
        assertEquals( listAdapter.getCount(), shops.size() );
    }


    @Test
    public void getShop_ReturnCorrectShop() throws Exception
    {
        for ( int index = 0; index < shops.size(); index++ )
        {
            assertEquals( listAdapter.getItem( index ),
                    shops.get( index ) );
        }
    }

    @Test
    public void getItemId_shouldReturnProperItemId() throws Exception
    {
        for ( int index = 0; index < shops.size(); index++ )
        {
            assertEquals( listAdapter.getItemId( index ), index );
        }
    }



}
