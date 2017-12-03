package com.shoponthego.shops;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoponthego.offers.Offer;
import com.shoponthego.shops.discounts.Discount;

@Service
public class ShopService {

	/*
	@Autowired
	private ShopRepository shopRepository;
	*/
	
	public List<Shop> getShops() {
		return null;
		/*
		List<Shop> shops = new ArrayList<>();
		shopRepository.findAll()
		.forEach(shops::add);
		return shops;
		*/
	}

	public Shop getShop(String id) {
		return null;
		//return shopRepository.findOne(id);
	}

	public void addShop(Shop shop) {
		//shopRepository.save(shop);
	}


	public void updateShop(String id, Shop updatedShop) {
		//shopRepository.save(updatedShop);
	}

	public void deleteShop(String id) {
	//	shopRepository.delete(id);
	}

	public List<Offer> getOffers(String shopId) {
		return null;
		/*
		Shop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getOffers();
		*/
	}

	public List<Discount> getDiscounts(String shopId) {
		Shop shop = getShop(shopId);
		if(shop == null) {
			return null;
		}
		return shop.getDiscounts();
	}

	public Offer getOffer(String shopId, String offerId) {
		return null;
				//shopRepository.findOfferById(offerId);
	}

	public void addOffer(String shopId, Offer offer) {
		
		
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