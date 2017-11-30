package com.sirialkillers.shoponthego.Models;

import java.util.ArrayList;

/**
 * @author Ioakeim James Theologou
 * @version 28/11/2017
 *
 */
public class UserModel extends ArrayList{
    private String userId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String country;
    private String region;
    private String city;
    private String address;
    private String postCode;
    private String wishListId;
    private String accountId;
    private boolean isShopOwner;

    public UserModel(String userId, String name, String surname, String email, String phone, String country, String region, String city, String address, String postCode, String wishListId, String accountId, boolean isShopOwner) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.region = region;
        this.city = city;
        this.address = address;
        this.postCode = postCode;
        this.wishListId = wishListId;
        this.accountId = accountId;
        this.isShopOwner = isShopOwner;
    }

    public UserModel(String userId, String name, String surname) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }


    public UserModel(String userId) {
        this.userId = userId;
    }

    public UserModel() {
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
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

    public String getWishListId() {

        return wishListId;
    }

    public void setWishListId(String wishListId) {

        this.wishListId = wishListId;
    }

    public String getAccountId() {

        return accountId;
    }

    public void setAccountId(String accountId) {

        this.accountId = accountId;
    }

    public boolean isShopOwner() {

        return isShopOwner;
    }

    public void setShopOwner(boolean shopOwner) {

        isShopOwner = shopOwner;
    }
}
