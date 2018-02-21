package com.sirialkillers.shoponthego.Shop_Related_Activities;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;
import com.sirialkillers.shoponthego.Controllers.ShopController;
import com.sirialkillers.shoponthego.Maps_Related_Activities.MarkerInformation;
import com.sirialkillers.shoponthego.Maps_Related_Activities.Position;
import com.sirialkillers.shoponthego.Models.CategoryModel;
import com.sirialkillers.shoponthego.Models.ShopModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Xristos Aslamagidis on 29/10/2017.
 */
public class ListOfShops {

    private List<ShopModel> shops = new ArrayList<>();
    private ArrayList<LatLng> shopsLocation = new ArrayList<>();
    private ArrayList<Marker>markers = new ArrayList<>();
    private ArrayList<MarkerInformation> markerinfo=new ArrayList<>();
    private List<ShopModel> filteredShops=new ArrayList<>();
    private List<CategoryModel> categoriesOfShops=new ArrayList<>();
    private ArrayList<String> chosenCategoryID=new ArrayList<>();
    ShopController shopController=new ShopController();



    public void addShop() {
        shops.clear();
        shops=shopController.get();
    }

    //TODO After merging add the shopController Method that fetches categories
    //TODO If getCategoryMethod is not ready just create the rest of the categories manually for now
    public void addCategory(){
        categoriesOfShops.add(new CategoryModel("1","Accessories","category1"));
        categoriesOfShops.add(new CategoryModel("2","Car","category2"));
        categoriesOfShops.add(new CategoryModel("3","Consumables","category3"));
        categoriesOfShops.add(new CategoryModel("4","Clothes","category4"));
        categoriesOfShops.add(new CategoryModel("5","Decoration","category5"));
    }

    public List<ShopModel> addFilteredShops(ArrayList<String> chosenCategoryId){
        filteredShops.clear();
        for(ShopModel shop:shops){
            for(String tmp:chosenCategoryId){
                if(shop.getCategoryId().equals(tmp)){
                    filteredShops.add(shop);
                }
            }
        }
        return filteredShops;
    }

    public List<ShopModel> getShop(){

        return shops;
    }



    public void creatPositionOfShop(){
        for (ShopModel shop:shops) {
            LatLng position =new LatLng(shop.getPosition().getLatitude(),shop.getPosition().getLongitude());
            String name=shop.getName();
            markerinfo.add(new MarkerInformation(position, name));

        }
    }

    public void creatPositionOfFilteredShops(){
        for (ShopModel shop:filteredShops) {
            LatLng position =new LatLng(shop.getPosition().getLatitude(),shop.getPosition().getLongitude());
            String name=shop.getName();
            markerinfo.add(new MarkerInformation(position, name));

        }
    }

    //Used to find the correct shopName from the shopId(currently not implemented)
    public String getShopName(String shopId){
        String id=shopId;
        String name=null;
        String s;
        for(ShopModel shop:shops){
            s=shop.getId();
            if(Objects.equals(id,s)){
                name=shop.getName();
            }
        }
        return name;
    }

    //used to find the correct shopId from the title of marker
    // (which is always the name of a shop in the Arraylist shops)
    public String findCorrectShop(String title,List<ShopModel> shops){
        String name=title;
        String s;
        String id=null;
        for (ShopModel shop:shops){
            s=shop.getName();
            if(Objects.equals(name, s)){
                id=shop.getId();
            }
        }
        if(id==null){
            id="Not Found";
        }
        return id;

    }

    public ArrayList<Marker> creatMarkerOfShop(GoogleMap googleMap){
        markerinfo.clear();
        this.creatPositionOfShop();


        for (MarkerInformation m:markerinfo) {

            markers.add( googleMap.addMarker(new MarkerOptions().position(m.getMarkerPosition()).title(m.getMarkerTitle())));

        }

        return markers;
    }

    public ArrayList<Marker> createMarkerOfFilteredShops(GoogleMap googleMap, ArrayList<String> chosenCategoriesNames){
        markerinfo.clear();
        chosenCategoryID.clear();
        this.createListOfCategoryIDsFromChosenCategoryNames(chosenCategoriesNames, categoriesOfShops);
        this.addFilteredShops(chosenCategoryID);
        this.creatPositionOfFilteredShops();


        for (MarkerInformation m:markerinfo) {

            markers.add( googleMap.addMarker(new MarkerOptions().position(m.getMarkerPosition()).title(m.getMarkerTitle())));

        }

        return markers;
    }


    public void ShowShopsMarkersInUserLocationRadious(LatLng location,int seekBarProgress){


        for (Marker marker :markers) {
            if (SphericalUtil.computeDistanceBetween(location,marker.getPosition())<seekBarProgress ) {
                marker.setVisible(true);
            }else{
                marker.setVisible(false);
            }

        }
    }

    public ArrayList<String> createListOfCategoryIDsFromChosenCategoryNames(ArrayList<String> chosenCategoryNames, List<CategoryModel> categoriesOfShops){
        chosenCategoryID.clear();
        for(String choice:chosenCategoryNames){
            for(CategoryModel cat:categoriesOfShops){
                if(choice.equals(cat.getCategoryName())){
                    chosenCategoryID.add(cat.getCategoryId());
                }
            }
        }
        return chosenCategoryID;
    }

}
