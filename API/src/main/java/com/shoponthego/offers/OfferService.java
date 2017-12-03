package com.shoponthego.offers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public List<Offer> getAllOffers() {
		List<Offer> offers = new ArrayList<>();
		offerRepository.findAll()
		.forEach(offers::add);
		return offers;
	}

	public Offer getOfferById(String id) {
		return offerRepository.findOne(id);
	}

	public void addOffer(Offer offer) {
		offerRepository.save(offer);
	}

	public void updateOffer(String id, Offer newOffer) {
		offerRepository.save(newOffer);
	}

	public void deleteOffer(String id) {
		offerRepository.delete(id);
	}
}
