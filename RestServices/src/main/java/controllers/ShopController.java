package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Shop;
import models.Shops;

@RestController
public class ShopController {
	
	private Shops shops;
	
	public ShopController() {
		shops = new Shops();
	}
	
	public void createShopList(Shops shops, String shop) {
		
		shops.addShop(new Shop(shop));
	}
	
	@RequestMapping(value="/shops")
	public Shops getAllShops() {
		return shops;
	}
}
