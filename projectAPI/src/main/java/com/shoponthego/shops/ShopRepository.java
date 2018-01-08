package com.shoponthego.shops;

import org.springframework.data.repository.CrudRepository;

import com.shoponthego.offers.Offer;


public interface ShopRepository extends CrudRepository<Shop, String> {

	public Offer findOfferById(String offerId);
}
