package com.shoponthego.offers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OfferService {

	private List<IOffer> offers;
	
	public List<IOffer> getAllOffers() {
		return offers;
	}

	public IOffer getOfferById(String id) {
		for (IOffer offer : offers) {
			if(offer.getId().equalsIgnoreCase(id)) {
				return offer;
			}
		}
		return null;
	}

	public void addOffer(IOffer offer) {
		offers.add(offer);
	}

	public void updateOffer(String id, IOffer newOffer) {
		for(int i=0; i<offers.size(); i++) {
			IOffer offer = offers.get(i);
			if(offer.getId().equalsIgnoreCase(id)) {
				offers.set(i, newOffer);
				return;
			}
		}		
	}

	public void deleteOffer(String id) {
		for(int i=0; i<offers.size(); i++) {
			IOffer offer = offers.get(i);
			if(offer.getId().equalsIgnoreCase(id)) {
				offers.remove(offer);
				return;
			}
		}		
	}
}
