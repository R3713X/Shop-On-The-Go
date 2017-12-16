package com.sirialkillers.shoponthego;

import com.sirialkillers.shoponthego.Maps_Related_Activities.Position;
import com.sirialkillers.shoponthego.Models.CategoryModel;
import com.sirialkillers.shoponthego.Models.ShopModel;
import com.sirialkillers.shoponthego.Shop_Related_Activities.ListOfShops;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 18-Nov-17.
 */

public class ListOfShopsTest {

    private ArrayList<ShopModel> mockShops;
    private List<CategoryModel> mockCategories;
    private ArrayList<String> mockChoices;
    ListOfShops listOfShops;

    @Before
    public void setUp() throws Exception{
        populateListOfShops();
        populateListOfCategories();
        listOfShops = new ListOfShops();
    }

    private void populateListOfShops()
    {
        mockShops= new ArrayList<>();
        mockShops.add(new ShopModel("1","rafaele", new Position(40.6657785,22.9468865),"1"));
        mockShops.add(new ShopModel("2","mavidis", new Position(40.6666259,22.9455427),"2"));
        mockShops.add(new ShopModel("3","porkys", new Position(40.663449,22.9475822),"3"));
        mockShops.add(new ShopModel("3","seven", new Position(40.6595399,22.9445063),"4"));
        mockShops.add(new ShopModel("4", "mad gym",new Position(40.6566813,22.9328894),"5"));
    }

    private void populateListOfCategories(){
        mockCategories=new ArrayList<>();
        mockCategories.add(new CategoryModel("1","Accessories","category1"));
        mockCategories.add(new CategoryModel("2","Car","category2"));
        mockCategories.add(new CategoryModel("3","Consumables","category3"));
        mockCategories.add(new CategoryModel("4","Clothes","category4"));
        mockCategories.add(new CategoryModel("5","Decoration","category5"));
        mockCategories.add(new CategoryModel("6","RandomTest6","category6"));
        mockCategories.add(new CategoryModel("7","RandomTest7","category7"));
        mockCategories.add(new CategoryModel("8","RandomTest8","category8"));
        mockCategories.add(new CategoryModel("9","RandomTest9","category9"));
    }


    @Test
    public void testFindCorrectShopsWithValidTitle() throws Exception{
        String title="rafaele";
        String returnedId;
        returnedId=listOfShops.findCorrectShop(title, mockShops);
        assertEquals("1", returnedId);
    }

    @Test
    public void testFindCorrectShopWithInvalidTitle() throws Exception{
        String title="adsada";
        String returnedId;
        returnedId=listOfShops.findCorrectShop(title, mockShops);
        assertEquals("Not Found", returnedId);
    }

    @Test
    public void testFindCorrectShopWithNullTitle() throws Exception{
        String title="null";
        String returnedId;
        returnedId=listOfShops.findCorrectShop(title,mockShops);
        assertEquals("Not Found", returnedId);
    }

    @Test
    public void testChosenCategoriesFoundInList(){
        mockChoices=new ArrayList<>();
        ArrayList<String> returnedCategoryIDs;
        mockChoices.add("RandomTest6");
        mockChoices.add("RandomTest7");
        returnedCategoryIDs=listOfShops.createListOfCategoryIDsFromChosenCategoryNames(mockChoices,mockCategories);
        assertEquals(2, returnedCategoryIDs.size());
    }

    @Test
    public void testChosenCategoriesNotFoundInList(){
        mockChoices=new ArrayList<>();
        ArrayList<String> returnedCategoryIDs;
        mockChoices.add("RandomTest6342852");
        mockChoices.add("RandomTest7214341");
        returnedCategoryIDs=listOfShops.createListOfCategoryIDsFromChosenCategoryNames(mockChoices,mockCategories);
        assertEquals(0, returnedCategoryIDs.size());
    }

    //Test runs by fluke, addFilteredShops needs refactoring
    @Test
    public void testNoShopsReturnForCategoriesChosen(){
        mockChoices=new ArrayList<>();
        ArrayList<String> returnedCategoryIDs;
        List<ShopModel> returnMockFilteredShops=new ArrayList<>();
        mockChoices.add("RandomTest6342852");
        mockChoices.add("RandomTest7214341");
        returnedCategoryIDs=listOfShops.createListOfCategoryIDsFromChosenCategoryNames(mockChoices,mockCategories);
        returnMockFilteredShops=listOfShops.addFilteredShops(returnedCategoryIDs);
        assertEquals(0, returnMockFilteredShops.size());
    }
    //addFilteredShops needs refactoring
    @Test
    public void testShopReturnedForCategoriesChosen(){
        mockChoices=new ArrayList<>();
        ArrayList<String> returnedCategoryIDs;
        List<ShopModel> returnMockFilteredShops=new ArrayList<>();
        mockChoices.add("Accessories");
        mockChoices.add("RandomTest7214341");
        returnedCategoryIDs=listOfShops.createListOfCategoryIDsFromChosenCategoryNames(mockChoices,mockCategories);
        returnMockFilteredShops=listOfShops.addFilteredShops(returnedCategoryIDs);
        assertEquals(1, returnMockFilteredShops.size());
    }


}
