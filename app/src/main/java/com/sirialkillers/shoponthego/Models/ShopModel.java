package com.sirialkillers.shoponthego.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.sirialkillers.shoponthego.Maps_Related_Activities.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 9/12/2017
 *
 */
@Entity(tableName="Shop")
public class ShopModel extends ArrayList{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="shopId")
    private String id;
    @ColumnInfo(name="shopName")
    private String name;
    @Embedded
    private Position position;
    @Embedded
    private String country;
    @Embedded
    private String region;
    @Embedded
    private String city;
    @Embedded
    private String address;
    @Embedded
    private String postCode;
    @Embedded
    private String userId;
    @Ignore
    private List<DiscountModel> discounts;
    @Ignore
    private List<OfferModel> offers;
    @Ignore
    private List<ProductModel> products;
    @Ignore
    private List <CategoryModel> categories;

    @Ignore
    public ShopModel(String id, String name, Position position, String country, String region, String city,
                     String address, String postCode, String userId){
        this.id=id;
        this.name=name;
        this.position=position;
        this.country=country;
        this.region=region;
        this.city=city;
        this.address=address;
        this.postCode=postCode;
        this.userId=userId;

    }

    public ShopModel(String id, String name, Position position){
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Ignore
    public ShopModel(String id, String name){
        this.id = id;
        this.name = name;
        this.position = new Position(0,0);
    }
    @Ignore
    public ShopModel(String id){
        this.id = id;
        this.name = "";
        this.position = new Position(0,0);
    }


    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Position getPosition() {

        return position;
    }

    public void setPosition(Position position) {

        this.position = position;
    }

    public List<OfferModel> getOffers() {

        return offers;
    }


    public OfferModel getOffer(String offerId) {

        return null;
    }

    public List<ProductModel> getAllProducts() {

        return products;
    }

    public ProductModel getProduct(String productId) {

        return null;
    }

    public List<DiscountModel> getAllDiscounts() {

        return discounts;
    }

    public void setDiscounts(List<DiscountModel> discounts) {
        this.discounts = discounts;
    }

    public void setOffers(List<OfferModel> offers) {

        this.offers = offers;
    }

    public void setProducts(List<ProductModel> products) {

        this.products = products;
    }

    public void setCategories(List<CategoryModel> categories) {

        this.categories = categories;
    }

    public List<DiscountModel> getDiscounts() {

        return discounts;
    }

    public List<ProductModel> getProducts() {

        return products;
    }

    public List<CategoryModel> getCategories() {

        return categories;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getRegion() {

        return region;
    }

    public void setRegion(String region) {

        this.region = region;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getPostCode() {

        return postCode;
    }

    public void setPostCode(String postCode) {

        this.postCode = postCode;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }
}
