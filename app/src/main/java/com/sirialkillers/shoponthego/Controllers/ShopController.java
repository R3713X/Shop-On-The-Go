package com.sirialkillers.shoponthego.Controllers;

import android.util.Log;

import com.sirialkillers.shoponthego.Interfaces.IController;
import com.sirialkillers.shoponthego.Models.DiscountModel;
import com.sirialkillers.shoponthego.Models.OfferModel;
import com.sirialkillers.shoponthego.Models.ProductModel;
import com.sirialkillers.shoponthego.Models.ShopModel;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ioakeim James Theologou
 * @version 29/11/2017
 *
 */
public class ShopController implements IController<ShopModel, String> {
    /* Rest Template is a template that is given by Spring Framework */
    private RestTemplate restTemplate = new RestTemplate();

    /* params is a Hash Map used to set the parameters that are going to be used
     in the Rest Template */
    private Map<String, String> params = new HashMap<>();

    /* Default values. */
    private ShopModel defaultShop;
    private DiscountModel defaultDiscount;
    private OfferModel defaultOffer;
    private ProductModel defaultProduct;

    /**
     * Initializes the default values and the Rest template that adds a
     * Jackson message converter so it can parse
     * a JSON file.
     */
    public ShopController() {
        defaultShop = new ShopModel("-1");
        defaultDiscount = new DiscountModel("-1");
        defaultOffer = new OfferModel("-1");
        defaultProduct = new ProductModel("-1");

        params = new HashMap<>();
        restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * Returns a list of shops that are accessible for further use.
     * @return the list of shops
     */
    @Override
    public List<ShopModel> get(){
        List<ShopModel> shops = new ArrayList<>();
        try {
            final String url = "http://localhost:8080/shops";

            shops.addAll(restTemplate.getForObject(url, ShopModel.class));
            return shops;
        }catch (Exception e){
            Log.e("getShops", e.getMessage(),e);
        }
        return shops;
    }

    /**
     * Returns a shop that matches the shopId.
     * @param shopId The id of the shop
     * @return the shop
     */
    @Override
    public ShopModel getById(String shopId) {
        try {
            final String url = "http://localhost:8080/shops/{shopId}";

            params.clear();
            params.put("shopId", shopId);

            ShopModel shop = restTemplate.getForObject(url, ShopModel.class, params);
            return shop;
        }catch (Exception e){
            Log.e("getShopById", e.getMessage(),e);
        }
        return defaultShop;
    }

    /**
     * Creates a new shop.
     * @param shop is the shop that will be created
     * @return the shop that was created
     */
    @Override
    public ShopModel create(ShopModel shop){
        try {
            final String url = "http://localhost:8080/shops";
            ShopModel shopThatWasCreated = restTemplate.postForObject(url, shop, ShopModel.class);
            return shopThatWasCreated;

        }catch (Exception e){
            Log.e("createShop", e.getMessage(),e);
        }
        return defaultShop;
    }


    /**
     * Updates an already existing shop.
     * @param shop is the shop that will get updated
     */
    @Override
    public void update(String targetShop, ShopModel shop){
        try {
            final String url = "http://localhost:8080/shops/{targetShop}";

            params.clear();
            params.put("targetShop", targetShop);

            restTemplate.put(url, shop, params);
        }catch (Exception e) {
            Log.e("updateShop", e.getMessage(), e);
        }
    }

    /**
     * Deletes a shop that exists.
     * @param shopId the id of the shop that will get deleted
     */
    @Override
    public void delete(String shopId){
        try {
            final String url = "http://localhost:8080/shops/{shopId}";

            params.clear();
            params.put("shopId", shopId);

            restTemplate.delete(url, params);
        }catch (Exception e){
            Log.e("getOffers", e.getMessage(),e);
        }
    }

    /**
     * returns a list of offers that are available
     * from that certain shop that matches the shopId.
     * @param shopId the shop that will return the offers.
     * @return a list of offers
     */
    public List<OfferModel> getShopOffers(String shopId){
        List<OfferModel> offers = new ArrayList<>();

        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers";

            params.clear();
            params.put("shopId",shopId);

            offers.addAll(restTemplate.getForObject(url, OfferModel.class, params));
            return offers;
        }catch (Exception e){
            Log.e("getShopOffers", e.getMessage(),e);
        }
        return offers;
    }

    /**
     * returns a offer that matches the shop and offer Id.
     * @param shopId the shop Id to match.
     * @param offerId the offer Id to match.
     * @return a offer.
     */
    public OfferModel getShopOffer(String shopId, String offerId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";

            params.clear();
            params.put("shopId",shopId);
            params.put("offerId", offerId);

            OfferModel offer = restTemplate.getForObject(url, OfferModel.class, params.get(0), params.get(1));
            return offer;
        }catch (Exception e){
            Log.e("getShopOffer", e.getMessage(),e);
        }
        return defaultOffer;
    }

    /**
     * Creates a new offer and adds it to the shop that matches the shopId.
     * @param shopId the shop that will add the offer.
     * @param offer the offer that will be added.
     */
    public void addShopOffer(String shopId, OfferModel offer){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers";

            params.clear();
            params.put("shopId", shopId);

            restTemplate.postForObject(url, offer, OfferModel.class, params);
        }catch (Exception e){
            Log.e("addShopOffer", e.getMessage(),e);
        }
    }

    /**
     * updates an already existing offer from a shop.
     * @param shopId the shop that has the offer.
     * @param offerId the offer Id that will get updated.
     * @param offer the offer that will replace the old offer.
     */
    public void updateShopOffer(String shopId, String offerId,  OfferModel offer){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("offerId", offerId);

            restTemplate.put(url, offer, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("updateShopOffer", e.getMessage(),e);
        }
    }

    /**
     * deletes a offer from a shop.
     * @param shopId the shop Id that has the offer.
     * @param offerId the offer Id that will get deleted.
     */
    public void deleteShopOffer(String shopId, String offerId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/offers/{offerId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("offerId", offerId);

            restTemplate.delete(url, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("deleteShopOffer", e.getMessage(),e);
        }
    }

    /**
     * returns a list of discounts that are available
     * from that certain shop that matches the shopId.
     * @param shopId the shop Id that contains the discounts.
     * @return a list of discounts.
     */
    public List<DiscountModel> getShopDiscounts(String shopId){
        List<DiscountModel> discounts = new ArrayList<>();

        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts";

            params.clear();
            params.put("shopId",shopId);

            discounts.addAll(restTemplate.getForObject(url, DiscountModel.class, params));
            return discounts;
        }catch (Exception e){
            Log.e("getShopDiscounts", e.getMessage(),e);
        }
        return discounts;
    }

    /**
     * returns a discount that matches the shop and discount ID.
     * @param shopId the shop to match.
     * @param discountId the discount to return.
     * @return a discount.
     */
    public DiscountModel getShopDiscount(String shopId, String discountId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts/{discountId}";

            params.clear();
            params.put("shopId",shopId);
            params.put("discountId", discountId);

            DiscountModel discount = restTemplate.getForObject(url, DiscountModel.class, params.get(0), params.get(1));
            return discount;
        }catch (Exception e){
            Log.e("getShopDiscount", e.getMessage(),e);
        }
        return defaultDiscount;
    }

    /**
     * creates a new discount and adds it to the shop that matches the shopId.
     * @param shopId the shop that will add the discount.
     * @param discount the discount that will be added.
     */
    public void addShopDiscount(String shopId, DiscountModel discount){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts";

            params.clear();
            params.put("shopId", shopId);

            restTemplate.postForObject(url, discount, DiscountModel.class, params);
        }catch (Exception e){
            Log.e("addShopDiscount", e.getMessage(),e);
        }
    }

    /**
     * updates an already existing discount from a shop.
     * @param shopId the shop that has the offer.
     * @param discountId the discount that will get updated.
     * @param discount the discount that will replace the old discount.
     */
    public void updateShopDiscount(String shopId, String discountId,  DiscountModel discount){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts/{discountId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("discountId", discountId);

            restTemplate.put(url, discount, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("updateShopDiscount", e.getMessage(),e);
        }
    }

    /**
     * deletes a discount from a shop.
     * @param shopId the shop Id that has the discount.
     * @param discountId the discount that will get deleted.
     */
    public void deleteShopDiscount(String shopId, String discountId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/discounts/{discountId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("discountId", discountId);

            restTemplate.delete(url, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("deleteShopDiscount", e.getMessage(),e);
        }
    }

    /**
     * returns a list of products that are available
     * by the shop that matches the shopId.
     * @param shopId the shop that will return its products.
     * @return a list of products.
     */
    public List<ProductModel> getShopProducts(String shopId){
        List<ProductModel> products = new ArrayList<>();

        try{
            final String url = "http://localhost:8080/shops/{shopId}/products";

            params.clear();
            params.put("shopId",shopId);

            products.addAll(restTemplate.getForObject(url, ProductModel.class, params));
            return products;
        }catch (Exception e){
            Log.e("getShopProducts", e.getMessage(),e);
        }
        return products;
    }

    /**
     * returns a product that matches the shop and the product Id.
     * @param shopId the shop Id to match.
     * @param productId the product Id to return.
     * @return a product.
     */
    public ProductModel getShopProduct(String shopId, String productId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/products/{productId}";

            params.clear();
            params.put("shopId",shopId);
            params.put("productId", productId);

            ProductModel product = restTemplate.getForObject(url, ProductModel.class, params.get(0), params.get(1));
            return product;
        }catch (Exception e){
            Log.e("getShopProduct", e.getMessage(),e);
        }
        return defaultProduct;
    }

    /**
     * creates a new product and adds it to the shop that matches the shopId.
     * @param shopId the shop that will add the product.
     * @param product the product that will be added.
     */
    public void addShopProduct(String shopId, ProductModel product){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/products";

            params.clear();
            params.put("shopId", shopId);

            restTemplate.postForObject(url, product, ProductModel.class, params);
        }catch (Exception e){
            Log.e("addShopProduct", e.getMessage(),e);
        }
    }

    /**
     * updates an already existing product from a shop.
     * @param shopId the shop that has the product.
     * @param productId the product that will get updated.
     * @param product the product that will replace the old one.
     */
    public void updateShopProduct(String shopId, String productId,  ProductModel product){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/products/{productId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("productId", productId);

            restTemplate.put(url, product, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("updateShopProduct", e.getMessage(),e);
        }
    }

    /**
     * deletes a product from the shop that matches the shopId.
     * @param shopId the shop that has the product.
     * @param productId the product that will get deleted.
     */
    public void deleteShopProduct(String shopId, String productId){
        try{
            final String url = "http://localhost:8080/shops/{shopId}/products/{productId}";

            params.clear();
            params.put("shopId", shopId);
            params.put("productId", productId);

            restTemplate.delete(url, params.get(0), params.get(1));
        }catch (Exception e){
            Log.e("deleteShopProduct", e.getMessage(),e);
        }
    }


}