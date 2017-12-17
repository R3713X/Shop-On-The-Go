package com.shoponthego.shops;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
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
}