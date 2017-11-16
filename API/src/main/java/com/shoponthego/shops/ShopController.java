package com.shoponthego.shops;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoponthego.offers.IOffer;
import com.shoponthego.shops.discounts.IDiscount;

@RestController
public class ShopController {
	
	@Autowired
	private IShopService shopService;
	
	@RequestMapping(method=RequestMethod.GET ,value="/shops")
	public List<IShop> getAllShops() {
		return shopService.getAllShops();
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/shops/{id}")
	public IShop getShopById(@PathVariable String id) {
		return shopService.getShop(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shops")
	public void addShop(@RequestBody IShop shop) {
		shopService.addShop(shop);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/shops/{id}")
	public void updateShop(@PathVariable String id , @RequestBody IShop shop) {
		shopService.updateShop(id, shop);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shops/{id}")
	public void deleteShop(@PathVariable String id) {
		shopService.deleteShop(id);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/shops/{shopId}/offers")
	public List<IOffer> getOffersForShop(@PathVariable String shopId) {
		return shopService.getOffers(shopId);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/shops/{shopId}/offers/{offerId}")
	public IOffer getOfferForShop(@PathVariable String shopId, @PathVariable String offerId) {
		return shopService.getOffer(shopId, offerId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shops/{shopId}/offers")
	public void addOffer(@PathVariable String shopId, @RequestBody IOffer offer) {
		shopService.addOffer(shopId, offer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/shops/{shopId}/offers/{offerId}")
	public void updateOffer(@PathVariable String shopId, @PathVariable String offerId, @RequestBody IOffer offer) {
		shopService.updateOffer(shopId, offerId, offer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shops/{shopId}/offers/{offerId}")
	public void deleteOffer(@PathVariable String shopId, @PathVariable String offerId) {
		shopService.deleteOffer(shopId, offerId);
	}
	@RequestMapping(method=RequestMethod.GET ,value="/shops/{shopId}/discounts")
	public List<IDiscount> getDiscountsForShop(@PathVariable String shopId) {
		return shopService.getDiscounts(shopId);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/shops/{shopId}/discounts/{discountId}")
	public IOffer getDiscountForShop(@PathVariable String shopId, @PathVariable String discountId) {
		return shopService.getDiscount(shopId, discountId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shops/{shopId}/discounts")
	public void addDiscount(@PathVariable String shopId, @RequestBody IDiscount discount) {
		shopService.addDiscount(shopId, discount);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/shops/{shopId}/discounts/{discountId}")
	public void updateDiscount(@PathVariable String shopId, @PathVariable String discountId, @RequestBody IDiscount discount) {
		shopService.updateDiscount(shopId, discountId, discount);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shops/{shopId}/discounts/{discountId}")
	public void deleteDiscount(@PathVariable String shopId, @PathVariable String discountId) {
		shopService.deleteDiscount(shopId, discountId);
	}
}
