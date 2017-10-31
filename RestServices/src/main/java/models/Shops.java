package models;

import java.util.ArrayList;
import java.util.List;

public class Shops {

	private List<Shop> shops ;

	public Shops() {
		shops = new ArrayList<>();
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void addShop(Shop newShop) {
		shops.add(newShop);
	}
	
	public void deleteShop(Shop deletedShop) {
		shops.remove(deletedShop);
	}

}
