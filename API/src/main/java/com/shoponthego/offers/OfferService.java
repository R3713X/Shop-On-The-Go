package com.shoponthego.offers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OfferService {

	
	
	public List<Offer> getAllOffers() {
		/*
		List<Offer> offers = new ArrayList<>();
		offerRepository.findAll()
		.forEach(offers::add);
		return offers;
		*/
		return null;
	}

	public Offer getOfferById(String id) {
		return null;
		
	}

	public void addOffer(Offer offer) {
		//offerRepository.save(offer);
	}

	public void updateOffer(String id, Offer newOffer) {
		//offerRepository.save(newOffer);
	}

	public void deleteOffer(String id) {
		//offerRepository.delete(id);
	}
}
