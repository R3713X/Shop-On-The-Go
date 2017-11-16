package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.IOffer;
import com.shoponthego.products.IProduct;
import com.shoponthego.shops.discounts.IDiscount;

@Service
public class ShopService implements IShopService {

	private List<IShop> shops = new ArrayList<>(Arrays.asList(
			new Shop("1213","Adidas Store",new Location("Papandreou", 22.41243,-87.2332)),
			new Shop("1214","Nike Store",new Location("Papandreou 11", 22.41243,-87.2332)),
			new Shop("1215","Adidas Store",new Location("Papandreou", 22.41243,-87.2332))
			));
	
	@Override
	public List<IShop> getAllShops() {
		return shops;
	}

	@Override
	public IShop getShop(String id) {
		for (IShop shop : shops) {
			if(shop.getId().equalsIgnoreCase(id)) {
				return shop;
			}
		}
		return null;
	}

	@Override
	public void addShop(IShop shop) {
		shops.add(shop);
	}

	@Override
	public void updateShop(String id, IShop updatedShop) {
		for (int i=0; i<shops.size(); i++) {
			IShop shop = shops.get(i);
			if(shop.getId().equalsIgnoreCase(id)) {
				shops.set(i, updatedShop);
				return;
			}
		}
	}

	@Override
	public void deleteShop(String id) {
		for (int i=0; i<shops.size(); i++) {
			IShop shop = shops.get(i);
			if(shop.getId().equalsIgnoreCase(id)) {
				shops.remove(shop);
				return;
			}
		}
	}

	@Override
	public List<IOffer> getOffers(String shopId) {
		IShop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getOffers();
	}

	@Override
	public void addShops(List<IShop> shops) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IProduct> getProducts(IShop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProduct getProduct(IShop shop, String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(IShop shop, IProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProducts(IShop shop, List<IProduct> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(IShop shop, IProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeProduct(IShop shop, String productId, IProduct newProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOffer(String shopId, IOffer offer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOffers(IShop shop, List<IOffer> offers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOffer(String shopId, String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOffer(String shopId, String offerId, IOffer newOffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IOffer getOffer(String shopId, String offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IDiscount> getDiscounts(String shopId) {
		IShop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getDiscounts();
	}

	@Override
	public IOffer getDiscount(String shopId, String discountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDiscount(String shopId, IDiscount discount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDiscount(String shopId, String discountId, IDiscount discount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDiscount(String shopId, String discountId) {
		// TODO Auto-generated method stub
		
	}
}