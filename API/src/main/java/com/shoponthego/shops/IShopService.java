package com.shoponthego.shops;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoponthego.offers.IOffer;
import com.shoponthego.products.IProduct;
import com.shoponthego.shops.discounts.IDiscount;

@Service
public interface IShopService {

	public List<IShop> getAllShops();
	public IShop getShop(String shopId);
	public void addShop(IShop shop);
	public void addShops(List<IShop> shops);
	public void deleteShop(String shopId);
	public void updateShop(String shopTarget, IShop newShop);
	
	public List<IProduct> getProducts(IShop shop);
	public IProduct getProduct(IShop shop , String productId);
	public void addProduct(IShop shop, IProduct product);
	public void addProducts(IShop shop, List<IProduct> products);
	public void deleteProduct(IShop shop, IProduct product);
	public void changeProduct(IShop shop, String productId, IProduct newProduct);
	
	public List<IOffer> getOffers(String shopId);
	public IOffer getOffer(String shopId, String offerId);
	public void addOffer(String shopId, IOffer offer);
	public void addOffers(IShop shop, List<IOffer> offers);
	public void updateOffer(String shopId, String offerId, IOffer newOffer);
	public void deleteOffer(String shopId, String offerId);
	
	public List<IDiscount> getDiscounts(String shopId);
	public IOffer getDiscount(String shopId, String discountId);
	public void addDiscount(String shopId, IDiscount discount);
	public void updateDiscount(String shopId, String discountId, IDiscount discount);
	public void deleteDiscount(String shopId, String discountId);
	
}
