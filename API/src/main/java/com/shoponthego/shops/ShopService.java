package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoponthego.locations.Location;
import com.shoponthego.offers.Offer;
import com.shoponthego.shops.discounts.Discount;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	private List<Shop> shops = new ArrayList<>(Arrays.asList(
			new Shop("1213","Adidas Store",new Location("Alexandrou 22", 22.4243,-87.1332)),
			new Shop("1214","Nike Store",new Location("Papandreou 11", 22.3123,-87.2221)),
			new Shop("1215","Puma Store",new Location("Mixaleos 8", 22.4323,-87.2732))
			));
	
	public List<Shop> getShops() {
		List<Shop> shops = new ArrayList<>();
		shopRepository.findAll()
		.forEach(shops::add);
		return shops;
	}

	public Shop getShop(String id) {
		return shopRepository.findOne(id);
	}

	public void addShop(Shop shop) {
		shopRepository.save(shop);
	}


	public void updateShop(String id, Shop updatedShop) {
		shopRepository.save(updatedShop);
	}

	public void deleteShop(String id) {
		shopRepository.delete(id);
	}

	public List<Offer> getOffers(String shopId) {
		Shop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getOffers();
	}

	public List<Discount> getDiscounts(String shopId) {
		Shop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getDiscounts();
	}

	public Offer getOffer(String shopId, String offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addOffer(String shopId, Offer offer) {
		// TODO Auto-generated method stub
		
	}

	public void updateOffer(String shopId, String offerId, Offer offer) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOffer(String shopId, String offerId) {
		// TODO Auto-generated method stub
		
	}

	public Offer getDiscount(String shopId, String discountId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addDiscount(String shopId, Discount discount) {
		// TODO Auto-generated method stub
		
	}

	public void updateDiscount(String shopId, String discountId, Discount discount) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDiscount(String shopId, String discountId) {
		// TODO Auto-generated method stub
		
	}


}